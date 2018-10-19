package lt.boldadmin.nexus.api.type.valueobject

import javax.validation.constraints.Size

data class Country(
    @field:Size(min = 1, message = "Country required")
    var name: String = ""
)
