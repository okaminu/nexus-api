package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.valueobject.Address
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class Project(

    var id: String? = null,

    @field:Size(min = 1, message = "Project Name required")
    var name: String = "",

    @field:NotNull(message = "Project Address required")
    var address: Address = Address(),

    @Min(0)
    var orderNumber: Short = 0

) {

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}
