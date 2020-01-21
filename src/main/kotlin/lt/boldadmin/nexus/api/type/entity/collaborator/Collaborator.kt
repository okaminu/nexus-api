package lt.boldadmin.nexus.api.type.entity.collaborator

import lt.boldadmin.nexus.api.type.annotation.MinimumWorkTimeLength
import lt.boldadmin.nexus.api.type.annotation.WorkTimeHasGapsBetweenDays
import lt.boldadmin.nexus.api.type.annotation.WorkTimeStartsBeforeEnd
import lt.boldadmin.nexus.api.type.entity.Person
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.time.DayOfWeek
import javax.validation.constraints.Min
import javax.validation.constraints.Size

class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    @field:Size(min = 7, max = 7)
    @field:MinimumWorkTimeLength
    @field:WorkTimeStartsBeforeEnd
    @field:WorkTimeHasGapsBetweenDays
    var workTime: List<TimeRange> = emptyList(),

    var enabledWorkDays: Set<DayOfWeek> = emptySet()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
