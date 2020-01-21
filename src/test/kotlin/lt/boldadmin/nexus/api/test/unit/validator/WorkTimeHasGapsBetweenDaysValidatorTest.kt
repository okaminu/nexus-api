package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.*
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkTimeHasGapsBetweenDaysValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WorkTimeHasGapsBetweenDaysValidatorTest {

    lateinit var validator: WorkTimeHasGapsBetweenDaysValidator

    @BeforeEach
    fun `Set up`() {
        validator = WorkTimeHasGapsBetweenDaysValidator()
    }

    @Test
    fun `Validation passes when time gap between work days time is longer than 15 minutes`() {
        val workTime = List(7) { TimeRange(100, 200) }

        assertTrue(validator.isValid(workTime, mockk()))
    }

    @Test
    fun `Validation passes when time gap between work days time is equal to 15 minutes`() {
        val workTime = List(7) { TimeRange(6, 1431) }

        assertTrue(validator.isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when time gap between work days time is shorter than 15 minutes`() {
        val workTime = List(7) { TimeRange(5, 1439) }

        assertFalse(validator.isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when there is no time gap between work days time`() {
        val workTime = List(7) { TimeRange(0, 1440) }

        assertFalse(validator.isValid(workTime, mockk()))
    }

    @Test
    fun `Validates every day`() {
        val workTimeWithInvalidSaturdaySunday = List(6) { TimeRange(1410, 1438) } + TimeRange(8, 200)
        val workTimeWithInvalidSundayMonday = listOf(TimeRange(8, 200)) + List(6) { TimeRange(1410, 1438) }

        assertFalse(validator.isValid(workTimeWithInvalidSaturdaySunday, mockk()))
        assertFalse(validator.isValid(workTimeWithInvalidSundayMonday, mockk()))
    }

    @Test
    fun `Validation short-circuits on first failure`() {
        val workTimeSpy = spyk(TimeRange(0, 1440))
        val workTime = List(2) { TimeRange(0, 1440) } + workTimeSpy + List(4) { TimeRange(0, 1440) }

        validator.isValid(workTime, mockk())

        verify { workTimeSpy wasNot called }
    }

}
