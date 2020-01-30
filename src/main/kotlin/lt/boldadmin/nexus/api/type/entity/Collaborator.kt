package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.*
import lt.boldadmin.nexus.api.type.valueobject.DayTime
import java.util.*
import javax.validation.constraints.Min

class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    @field:WorkWeekValidInput
    @field:MinimumWorkTimeLength
    @field:WorkTimeStartsBeforeEnd
    @field:WorkTimeHasGapsBetweenDays
    var workWeek: SortedSet<DayTime> = sortedSetOf()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
