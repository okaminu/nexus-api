package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.collaborator.Collaborator


interface CollaboratorRepository {

    fun save(collaborator: Collaborator)

    fun findAll(): Collection<Collaborator>

    fun findById(id: String): Collaborator

    fun findFirstByMobileNumber(mobileNumber: String): Collaborator

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Collaborator>

    fun existsById(id: String): Boolean

    fun existsByMobileNumber(mobileNumber: String): Boolean

}
