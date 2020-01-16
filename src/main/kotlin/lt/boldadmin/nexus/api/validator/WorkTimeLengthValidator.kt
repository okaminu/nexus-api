package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.annotation.WorkTimeLength
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class WorkTimeLengthValidator: ConstraintValidator<WorkTimeLength, Array<TimeRange>> {

    override fun isValid(workTime: Array<TimeRange>, context: ConstraintValidatorContext) =
        workTime.all{ it.endOfDayInMinutes - it.startOfDayInMinutes >= MINIMUM_MINUTES}

    companion object {
        private val MINIMUM_MINUTES = 15
    }

}
