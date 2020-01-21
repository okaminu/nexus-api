package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.mockk
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkTimeStartsBeforeEndValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WorkTimeStartsBeforeEndValidatorTest {

    @Test
    fun `Validation passes when all work days start time follows before end time`() {
        val workTime = List(7) { TimeRange(0, 100) }

        assertTrue(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation passes when work days start time equals end time`() {
        val workTime = List(7) { TimeRange(100, 100) }

        assertTrue(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when at least one work day start time follows after end time`() {
        val workTime = List(6) { TimeRange(0, 100) } + TimeRange(30, 20)

        assertFalse(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

}
