package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Collaborator

interface CollaboratorService {
    fun save(collaborator: Collaborator)
    fun getById(id: String): Collaborator
    fun getByMobileNumber(number: String): Collaborator
    fun createWithDefaults(): Collaborator
    fun existsById(id: String): Boolean
    fun existsByMobileNumber(number: String): Boolean
    fun update(id: String, attributeName: String, attributeValue: String)
    fun updateOrderNumber(collaboratorId: String, orderNumber: Short)
}