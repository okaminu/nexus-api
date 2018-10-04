package lt.boldadmin.nexus.api.type.entity
import javax.validation.constraints.Size

class User(

    var company: Company = Company(),

    @field:Size(min = 1, message = "Last name required")
    var lastName: String = "",

    @field:Size(min = 8, message = "Password should contain at least 8 symbols")
    var password: String = "",

    var role: String = ""

) : Person() {

    fun getCustomers(): Collection<Customer> = company.customers

}
