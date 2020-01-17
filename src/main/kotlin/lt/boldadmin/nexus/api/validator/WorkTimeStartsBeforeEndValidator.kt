package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange

class WorkTimeStartsBeforeEndValidator {

    fun isValid(workTime: Array<TimeRange>) = workTime.all { it.startOfDayInMinutes <= it.endOfDayInMinutes }

}
