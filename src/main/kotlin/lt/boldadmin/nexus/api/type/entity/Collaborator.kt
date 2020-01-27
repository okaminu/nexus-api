package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.MinimumWorkTimeLength
import lt.boldadmin.nexus.api.type.annotation.WorkTimeHasGapsBetweenDays
import lt.boldadmin.nexus.api.type.annotation.WorkTimeStartsBeforeEnd
import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import java.util.*
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
    var workWeek: SortedSet<WorkDay> = sortedSetOf()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
