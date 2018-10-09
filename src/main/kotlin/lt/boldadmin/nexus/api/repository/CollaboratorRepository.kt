package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Collaborator
import java.util.*

interface CollaboratorRepository {

    fun save(collaborator: Collaborator)


    fun findAll(): Collection<Collaborator>

    fun findById(id: String): Collaborator

    fun findByMobileNumber(mobileNumber: String): Collaborator

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Collaborator>


    fun existsById(id: String): Boolean

    fun existsByMobileNumber(mobileNumber: String): Boolean

}