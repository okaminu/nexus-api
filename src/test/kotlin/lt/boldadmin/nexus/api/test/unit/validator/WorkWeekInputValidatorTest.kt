package lt.boldadmin.nexus.api.test.unit.validator

import lt.boldadmin.nexus.api.type.extension.createSortedDaysOfWeek
import lt.boldadmin.nexus.api.type.extension.withTime
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.WorkWeekInputValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.TUESDAY

class WorkWeekInputValidatorTest {

    @Test
    fun `Validation passes when work week satisfies all input requirements`() {
        assertTrue(WorkWeekInputValidator().isValid(WORK_WEEK))
    }

    @Test
    fun `Validation fails when work week does not contain 7 day times`() {
        assertFalse(WorkWeekInputValidator().isValid(sortedSetOf()))
    }

    @Test
    fun `Validation fails when work week contains unbounded day of week index`() {
        val invalidWorkWeek =
            WORK_WEEK
                .toMutableList()
                .apply { this[1] = this[1].copy(dayOfWeekIndex = 7) }
                .toSortedSet()

        assertFalse(WorkWeekInputValidator().isValid(invalidWorkWeek))
    }

    @Test
    fun `Validation fails when work week contains negative day of week index`() {
        val invalidWorkWeek =
            WORK_WEEK
                .toMutableList()
                .apply { this[1] = this[1].copy(dayOfWeekIndex = -1) }
                .toSortedSet()

        assertFalse(WorkWeekInputValidator().isValid(invalidWorkWeek))
    }

    @Test
    fun `Validation fails when work week contains time with more minutes than there are in a day`() {
        val invalidWorkWeek = WORK_WEEK.withTime(TimeRange(100, 1441), TUESDAY)

        assertFalse(WorkWeekInputValidator().isValid(invalidWorkWeek))
    }

    @Test
    fun `Validation fails when work week contains time with negative minutes`() {
        val invalidWorkWeek = WORK_WEEK.withTime(TimeRange(-1, 100), TUESDAY)

        assertFalse(WorkWeekInputValidator().isValid(invalidWorkWeek))
    }

    companion object {
        private val WORK_WEEK = createSortedDaysOfWeek(TimeRange(0, 1440))
    }

}
