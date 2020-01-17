package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange

class WorkTimeBetweenDaysValidator {

    fun isValid(workTime: Array<TimeRange>): Boolean {
        for (i: Int in 0..workTime.size - 2)
            if (!(workTime[i] isDistanced workTime[i + 1]))
                return false
        return workTime[6] isDistanced workTime[0]
    }

    private infix fun TimeRange.isDistanced(that: TimeRange): Boolean =
        DAY_IN_MINUTES - this.endOfDayInMinutes + that.startOfDayInMinutes >= MINIMUM_MINUTES_BETWEEN_WORK_DAYS

    companion object {
        private val DAY_IN_MINUTES = 1440
        private val MINIMUM_MINUTES_BETWEEN_WORK_DAYS = 10
    }

}
