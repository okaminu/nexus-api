package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.collaborator.CollaboratorCoordinates

interface CollaboratorCoordinatesRepository {
    fun save(collaboratorCoordinates: CollaboratorCoordinates)
    fun removeOlderThan(collaboratorId: String, timestamp: Long)
    fun findByCollaboratorId(collaboratorId: String): Collection<CollaboratorCoordinates>
}
