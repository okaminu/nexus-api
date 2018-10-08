package lt.boldadmin.nexus.api.gateway.repository

import lt.boldadmin.nexus.api.type.entity.Customer

interface CustomerRepositoryGateway  {

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Customer>

    fun save(customer: Customer)

    fun findById(id: String): Customer

}
