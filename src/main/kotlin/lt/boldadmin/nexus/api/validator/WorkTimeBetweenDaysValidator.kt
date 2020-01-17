package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange

class WorkTimeBetweenDaysValidator {

    fun isValid(workTime: Array<TimeRange>): Boolean {
        for (i: Int in 0..workTime.size - 2)
            if (1440 - workTime[i].endOfDayInMinutes + workTime[i + 1].startOfDayInMinutes < 10)
                return false
        return 1440 - workTime[6].endOfDayInMinutes + workTime[0].startOfDayInMinutes >= 10
    }

}
