package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import lt.boldadmin.nexus.api.service.UserService
import lt.boldadmin.nexus.api.type.entity.Project
import lt.boldadmin.nexus.api.type.entity.User
import lt.boldadmin.nexus.api.validator.UniqueProjectNameValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UniqueProjectNameValidatorTest {

    @MockK
    private lateinit var userServiceStub: UserService

    private lateinit var validator: UniqueProjectNameValidator

    @BeforeEach
    fun `Set up`() {
        validator = UniqueProjectNameValidator().apply {
            userService = userServiceStub
        }

        validator.initialize(mockk())
        every { userServiceStub.getByProjectId(PROJECT_ID) } returns createUser()
    }

    @Test
    fun `Validation fails when duplicate Project name is found`() {
        every { userServiceStub.isProjectNameUnique(PROJECT_NAME, PROJECT_ID, USER_ID) } returns false

        assertFalse(
            validator.isValid(Project(PROJECT_ID, PROJECT_NAME), mockk())
        )
    }

    @Test
    fun `Validation passes when no duplicate Project name is found`() {
        every { userServiceStub.isProjectNameUnique(PROJECT_NAME, PROJECT_ID, USER_ID) } returns true

        assertTrue(
            validator.isValid(Project(PROJECT_ID, PROJECT_NAME), mockk())
        )
    }

    private fun createUser() = User().apply { id = USER_ID }

    companion object {
        private val USER_ID = "USER_ID"
        private val PROJECT_ID = "PROJECT_ID"
        private val PROJECT_NAME = "validation implementation"
    }

}
