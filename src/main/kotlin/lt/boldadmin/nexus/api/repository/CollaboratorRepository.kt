package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Collaborator
import java.util.*

interface CollaboratorRepository {

    fun save(collaborator: Collaborator)

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Collaborator>

    fun findByMobileNumber(mobileNumber: String): Collaborator

    fun existsByMobileNumber(mobileNumber: String): Boolean

    fun findById(id: String): Collaborator

    fun existsById(id: String): Boolean

    fun findAll(): Collection<Collaborator>

}