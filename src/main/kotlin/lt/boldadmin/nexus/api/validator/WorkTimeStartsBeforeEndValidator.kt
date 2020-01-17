package lt.boldadmin.nexus.api.validator

import lt.boldadmin.nexus.api.type.annotation.WorkTimeStartsBeforeEnd
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class WorkTimeStartsBeforeEndValidator: ConstraintValidator<WorkTimeStartsBeforeEnd, Array<TimeRange>> {

    override fun isValid(workTime: Array<TimeRange>, context: ConstraintValidatorContext) =
        workTime.all { it.startOfDayInMinutes <= it.endOfDayInMinutes }

}
