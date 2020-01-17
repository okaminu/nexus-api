package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.time.DayOfWeek

class WorkTimeBetweenDaysValidator {

    fun isValid(workTime: Array<TimeRange>) =
        (DayOfWeek.values() + DayOfWeek.MONDAY)
            .asSequence()
            .zipWithNext()
            .all { (firstDay, secondDay) -> workTime[firstDay.ordinal] isDistanced workTime[secondDay.ordinal] }

    private infix fun TimeRange.isDistanced(that: TimeRange): Boolean =
        DAY_IN_MINUTES - this.endOfDayInMinutes + that.startOfDayInMinutes >= MINIMUM_MINUTES_BETWEEN_WORK_DAYS

    companion object {
        private val DAY_IN_MINUTES = 1440
        private val MINIMUM_MINUTES_BETWEEN_WORK_DAYS = 10
    }

}
