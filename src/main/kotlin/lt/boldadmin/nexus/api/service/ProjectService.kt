package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.exception.InvalidValueException
import lt.boldadmin.nexus.api.type.entity.Project

interface ProjectService {
    fun createWithDefaults(userId: String): Project
    fun getById(projectId: String): Project
    fun update(id: String, attributeName: String, attributeValue: String)

    @Throws(InvalidValueException::class)
    fun updateOrderNumber(projectId: String, orderNumber: Short)
}