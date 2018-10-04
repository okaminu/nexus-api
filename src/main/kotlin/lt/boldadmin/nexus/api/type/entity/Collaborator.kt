package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import javax.validation.constraints.Min

class Collaborator(

    var hmsCardNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0,

    var workTime: TimeRange = TimeRange(0, 0)

) : Person() {

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}