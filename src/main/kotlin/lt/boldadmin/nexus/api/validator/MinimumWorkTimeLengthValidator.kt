package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.annotation.MinimumWorkTimeLength
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class MinimumWorkTimeLengthValidator: ConstraintValidator<MinimumWorkTimeLength, List<TimeRange>> {

    override fun isValid(workTime: List<TimeRange>, context: ConstraintValidatorContext) =
        workTime.all{ it.endOfDayInMinutes - it.startOfDayInMinutes >= MINIMUM_MINUTES}

    companion object {
        private val MINIMUM_MINUTES = 15
    }

}
