package lt.boldadmin.nexus.api.test.unit.validator

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import lt.boldadmin.nexus.api.service.UserService
import lt.boldadmin.nexus.api.type.entity.Project
import lt.boldadmin.nexus.api.type.entity.User
import lt.boldadmin.nexus.api.validator.UniqueProjectNameValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UniqueProjectNameValidatorTest {

    @Mock
    private lateinit var userServiceStub: UserService

    private lateinit var validator: UniqueProjectNameValidator

    @BeforeEach
    fun `Set up`() {
        validator = UniqueProjectNameValidator().apply {
            userService = userServiceStub
        }

        validator.initialize(mock())
        doReturn(createUser()).`when`(userServiceStub).getByProjectId(PROJECT_ID)
    }

    @Test
    fun `Validation fails when duplicate Project name is found`() {
        doReturn(false).`when`(userServiceStub).isProjectNameUnique(PROJECT_NAME, PROJECT_ID, USER_ID)

        assertFalse(validator.isValid(Project(PROJECT_ID, PROJECT_NAME), mock()))
    }

    @Test
    fun `Validation passes when no duplicate Project name is found`() {
        doReturn(true).`when`(userServiceStub).isProjectNameUnique(PROJECT_NAME, PROJECT_ID, USER_ID)

        assertTrue(validator.isValid(Project(PROJECT_ID, PROJECT_NAME), mock()))
    }

    private fun createUser() = User().apply { id = USER_ID }

    companion object {
        private val USER_ID = "USER_ID"
        private val PROJECT_ID = "PROJECT_ID"
        private val PROJECT_NAME = "validation implementation"
    }

}