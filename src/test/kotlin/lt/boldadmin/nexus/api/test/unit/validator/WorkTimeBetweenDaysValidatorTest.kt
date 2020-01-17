package lt.boldadmin.nexus.api.test.unit.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkTimeBetweenDaysValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WorkTimeBetweenDaysValidatorTest {

    @Test
    fun `Validation passes when time gap between work days time is longer than 10 minutes`() {
        val workTime = Array(7) { TimeRange(100, 200) }

        assertTrue(WorkTimeBetweenDaysValidator().isValid(workTime))
    }

    @Test
    fun `Validation passes when time gap between work days time is equal to 10 minutes (5 + 5 minutes)`() {
        val workTime = Array(6) { TimeRange(5, 1435) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(5, 200)) + Array(6) { TimeRange(1400, 1435) }

        assertTrue(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertTrue(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation passes when time gap between work days time is equal to 10 minutes (3 + 7 minutes)`() {
        val workTime = Array(6) { TimeRange(7, 1437) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(7, 200)) + Array(6) { TimeRange(1400, 1437) }

        assertTrue(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertTrue(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation passes when time gap between work days time is equal to 10 minutes (7 + 3 minutes)`() {
        val workTime = Array(6) { TimeRange(3, 1433) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(3, 200)) + Array(6) { TimeRange(1400, 1433) }

        assertTrue(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertTrue(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation fails when time gap between work days time is shorter than 10 minutes (3 + 3 minutes)`() {
        val workTime = Array(6) { TimeRange(3, 1437) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(3, 200)) + Array(6) { TimeRange(1400, 1437) }

        assertFalse(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertFalse(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation fails when time gap between work days time is shorter than 10 minutes (1 + 5 minutes)`() {
        val workTime = Array(6) { TimeRange(5, 1439) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(5, 200)) + Array(6) { TimeRange(1400, 1439) }

        assertFalse(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertFalse(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation fails when time gap between work days time is shorter than 10 minutes (5 + 1 minutes)`() {
        val workTime = Array(6) { TimeRange(1, 1435) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(1, 200)) + Array(6) { TimeRange(1400, 1435) }

        assertFalse(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertFalse(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

    @Test
    fun `Validation fails when there is no time gap between work days time`() {
        val workTime = Array(6) { TimeRange(0, 1440) } + TimeRange(100, 200)
        val sundayMondayWorkTime = arrayOf(TimeRange(0, 100)) + Array(6) { TimeRange(1440, 1440) }

        assertFalse(WorkTimeBetweenDaysValidator().isValid(workTime))
        assertFalse(WorkTimeBetweenDaysValidator().isValid(sundayMondayWorkTime))
    }

}
