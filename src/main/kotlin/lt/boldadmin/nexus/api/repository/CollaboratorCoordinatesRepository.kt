package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.CollaboratorCoordinates

interface CollaboratorCoordinatesRepository {
    fun save(collaboratorCoordinates: CollaboratorCoordinates)
    fun removeByCollaboratorId(collaboratorId: String)
    fun existsByCollaboratorId(collaboratorId: String): Boolean
}