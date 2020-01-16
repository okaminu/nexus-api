package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.entity.collaborator.Collaborator

class WorkTimeLengthValidator {

    fun isValid(c: Collaborator) = c.workTime.all{ it.endOfDayInMinutes - it.startOfDayInMinutes >= MINIMUM_MINUTES}

    companion object {
        private val MINIMUM_MINUTES = 15
    }

}
