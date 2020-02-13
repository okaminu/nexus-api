package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.*
import lt.boldadmin.nexus.api.type.valueobject.DayMinuteInterval
import java.util.*
import javax.validation.constraints.Min

data class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    @field:WeekSize
    @field:BoundedMinuteIntervals
    @field:DayMinutesStartBeforeEnd
    @field:MinuteRangeMinLength
    @field:MinuteRangesHaveGapsBetweenDays
    var workWeek: SortedSet<DayMinuteInterval> = sortedSetOf()

): Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }

}
