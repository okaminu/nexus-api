package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.exception.InvalidValueException
import lt.boldadmin.nexus.api.type.entity.Customer

interface CustomerService {
    fun save(customer: Customer)
    fun createWithDefaults(userId: String): Customer
    fun getById(id: String): Customer

    @Throws(InvalidValueException::class)
    fun update(id: String, attributeName: String, attributeValue: String)

    @Throws(InvalidValueException::class)
    fun updateOrderNumber(customerId: String, orderNumber: Short)
}