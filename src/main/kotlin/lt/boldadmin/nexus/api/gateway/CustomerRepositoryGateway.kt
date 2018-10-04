package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.entity.Customer
import java.util.*

interface CustomerRepositoryGateway  {

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Customer>

    fun save(customer: Customer)

    fun findById(id: String): Optional<Customer>

}
