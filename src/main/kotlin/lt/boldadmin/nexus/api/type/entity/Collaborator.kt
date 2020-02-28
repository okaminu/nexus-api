package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.*
import lt.boldadmin.nexus.api.type.valueobject.time.DayMinuteInterval
import java.util.*
import javax.validation.constraints.Min

class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    @field:SevenDayWeek
    @field:BoundedMinuteIntervals
    @field:StartBeforeEndMinutes
    @field:MinDuration
    @field:GappedDays
    var workWeek: SortedSet<DayMinuteInterval> = sortedSetOf()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
