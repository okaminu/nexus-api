package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Customer

interface CustomerRepository  {

    fun save(customer: Customer)


    fun findById(id: String): Customer

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Customer>

}
