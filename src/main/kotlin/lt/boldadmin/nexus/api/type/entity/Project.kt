package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.valueobject.Address
import lt.boldadmin.nexus.api.type.validator.UniqueProjectName
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class Project(

    var id: String? = null,

    @field:Size(min = 1, message = "Project name required")
    @field:UniqueProjectName()
    var name: String = "",

    @field:NotNull(message = "Project address required")
    var address: Address = Address(),

    @field:Min(value = 0, message = "Project order number must be greater than 0")
    var orderNumber: Short = 0

) {

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}
