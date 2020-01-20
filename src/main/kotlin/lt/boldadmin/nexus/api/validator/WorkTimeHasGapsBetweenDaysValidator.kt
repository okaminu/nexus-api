package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.annotation.WorkTimeHasGapsBetweenDays
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.time.DayOfWeek
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class WorkTimeHasGapsBetweenDaysValidator: ConstraintValidator<WorkTimeHasGapsBetweenDays, Array<TimeRange>> {

    override fun isValid(workTime: Array<TimeRange>, context: ConstraintValidatorContext) =
        (DayOfWeek.values() + DayOfWeek.MONDAY)
            .asSequence()
            .zipWithNext()
            .all { (firstDay, secondDay) -> workTime[firstDay.ordinal] isDistanced workTime[secondDay.ordinal] }

    private infix fun TimeRange.isDistanced(that: TimeRange): Boolean =
        MINUTES_IN_A_DAY - this.endOfDayInMinutes + that.startOfDayInMinutes >= MINIMUM_MINUTES_BETWEEN_WORK_DAYS

    companion object {
        private val MINUTES_IN_A_DAY = 1440
        private val MINIMUM_MINUTES_BETWEEN_WORK_DAYS = 15
    }

}
