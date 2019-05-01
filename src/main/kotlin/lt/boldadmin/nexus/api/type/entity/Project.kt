package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.annotation.UniqueProjectName
import lt.boldadmin.nexus.api.type.valueobject.Location
import java.util.HashSet
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@UniqueProjectName
class Project(

    var id: String = "",

    @field:Size(min = 1, message = "Project name required")
    var name: String = "",

    @field:Valid
    var locations: MutableCollection<Location> = HashSet(),

    @field:Min(value = 0, message = "Project order number must be a positive number")
    var orderNumber: Short = 0

) {

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}
