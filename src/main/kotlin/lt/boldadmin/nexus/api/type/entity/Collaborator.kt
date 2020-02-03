package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.*
import lt.boldadmin.nexus.api.type.valueobject.Day
import java.util.*
import javax.validation.constraints.Min

class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    @field:ValidWorkWeekInput
    @field:WorkTimeStartsBeforeEnd
    @field:MinimumWorkTimeLength
    @field:WorkTimeHasGapsBetweenDays
    var workWeek: SortedSet<Day> = sortedSetOf()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
