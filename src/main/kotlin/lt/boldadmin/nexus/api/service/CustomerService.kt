package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Customer

interface CustomerService {
    fun save(customer: Customer)
    fun createWithDefaults(userId: String): Customer
    fun getById(id: String): Customer
    fun update(id: String, attributeName: String, attributeValue: String)
    fun updateOrderNumber(customerId: String, orderNumber: Short)
}