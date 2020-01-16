package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.valueobject.TimeRange

class WorkTimeLengthValidator {

    fun isValid(workTime: Array<TimeRange>) =
        workTime.all{ it.endOfDayInMinutes - it.startOfDayInMinutes >= MINIMUM_MINUTES}

    companion object {
        private val MINIMUM_MINUTES = 15
    }

}
