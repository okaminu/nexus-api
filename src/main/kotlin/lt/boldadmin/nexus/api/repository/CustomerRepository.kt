package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Customer

interface CustomerRepository  {

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Customer>

    fun save(customer: Customer)

    fun findById(id: String): Customer

}
