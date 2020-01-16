package lt.boldadmin.nexus.api.test.unit.validator

import lt.boldadmin.nexus.api.type.entity.collaborator.Collaborator
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkTimeLengthValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WorkTimeLengthValidatorTest {

    @Test
    fun `Validation passes when all work days time is not shorter than 15 minutes`() {
        val collaborator = Collaborator().apply {
            workTime = Array(7) { TimeRange(0, 100) }
        }

        assertTrue(WorkTimeLengthValidator().isValid(collaborator))
    }

    @Test
    fun `Validation passes when work days with length of 15 minutes are contained`() {
        val collaborator = Collaborator().apply {
            workTime = Array(7) { TimeRange(5, 20) }
        }

        assertTrue(WorkTimeLengthValidator().isValid(collaborator))
    }

    @Test
    fun `Validation fails when at least one work day time is shorter than 15 minutes`() {
        val collaborator = Collaborator().apply {
            workTime = Array(7) { TimeRange(0, 100) }
            workTime[2] = TimeRange(20, 30)
        }

        assertFalse(WorkTimeLengthValidator().isValid(collaborator))
    }

}
