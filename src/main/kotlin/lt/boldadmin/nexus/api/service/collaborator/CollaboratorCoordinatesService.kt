package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.entity.collaborator.CollaboratorCoordinates

interface CollaboratorCoordinatesService {
    fun getByCollaboratorId(id: String): Collection<CollaboratorCoordinates>
}
