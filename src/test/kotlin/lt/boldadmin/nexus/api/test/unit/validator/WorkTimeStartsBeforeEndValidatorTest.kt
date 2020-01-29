package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.*
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkTimeStartsBeforeEndValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WorkTimeStartsBeforeEndValidatorTest {

    @Test
    fun `Validation passes when all day start times follows before end times`() {
        val workTime = List(7) { TimeRange(0, 100) }

        assertTrue(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation passes when day start times equals end times`() {
        val workTime = List(7) { TimeRange(100, 100) }

        assertTrue(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when at least one day start time follows after end time`() {
        val workTime = List(6) { TimeRange(0, 100) } + TimeRange(30, 20)

        assertFalse(WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation short-circuits on first failure`() {
        val workTimeSpy = spyk(TimeRange(30, 20))
        val workTime = listOf(TimeRange(30, 20)) + workTimeSpy + List(5) { TimeRange(30, 20) }

        WorkTimeStartsBeforeEndValidator().isValid(workTime, mockk())

        verify { workTimeSpy wasNot called }
    }


}
