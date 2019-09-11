package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.valueobject.Address
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

open class Person(

    var id: String = "",

    @field:Size(min = 1, message = "Name required")
    var name: String = "",

    @field:NotNull(message = "Address required")
    var address: Address = Address(),

    @field:Pattern(
        regexp = "^(?:[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)?$",
        message = "Invalid email address"
    )
    var email: String = ""

)
