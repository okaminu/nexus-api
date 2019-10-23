package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.valueobject.CollaboratorCoordinates

interface CollaboratorCoordinatesRepository {
    fun save(collaboratorCoordinates: CollaboratorCoordinates)
    fun removeOlderThan(timestamp: Long, collaboratorId: String)
    fun findByCollaboratorId(collaboratorId: String): Collection<CollaboratorCoordinates>
}
