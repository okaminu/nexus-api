package lt.boldadmin.nexus.api.type.valueobject

import javax.validation.constraints.NotNull

data class Address(
    var street: String = "",

    var postCode: String = "",

    var city: String = "",

    @field:NotNull(message = "Country required")
    var country: Country = Country()
)