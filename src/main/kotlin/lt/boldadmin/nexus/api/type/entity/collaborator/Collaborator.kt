package lt.boldadmin.nexus.api.type.entity.collaborator

import lt.boldadmin.nexus.api.type.entity.Person
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.time.DayOfWeek
import javax.validation.constraints.Min

class Collaborator(

    var hseCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    var workTime: TimeRange = TimeRange(0, 0),

    var enabledWorkDays: Set<DayOfWeek> = emptySet()

) : Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}
