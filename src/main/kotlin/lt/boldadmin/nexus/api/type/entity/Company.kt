package lt.boldadmin.nexus.api.type.entity

import java.util.*
import javax.validation.constraints.Size

class Company(

    var id: String? = null,

    @field:Size(min = 1, message = "Company name required")
    var name: String = "",

    var customers: MutableCollection<Customer> = HashSet(),

    var collaborators: MutableCollection<Collaborator> = HashSet()

) {

    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun addCollaborator(collaborator: Collaborator) {
        collaborators.add(collaborator)
    }

}
