package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.DayTime
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.util.*

class WorkWeekInputValidator {

    fun isValid(workWeek: SortedSet<DayTime>) =
        workWeek.size == 7 && workWeek.all {
            isBounded(it.dayOfWeekIndex) && isBounded(it.time)
        }

    private fun isBounded(dayOfWeekIndex: Int) = dayOfWeekIndex in 0..6

    private fun isBounded(timeRange: TimeRange) =
        timeRange.startOfDayInMinutes >= 0 && timeRange.endOfDayInMinutes <= MINUTES_IN_A_DAY

    companion object {
        private val MINUTES_IN_A_DAY = 1440
    }

}
