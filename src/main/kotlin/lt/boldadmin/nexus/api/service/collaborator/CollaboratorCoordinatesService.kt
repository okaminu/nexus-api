package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.valueobject.CollaboratorCoordinates

interface CollaboratorCoordinatesService {
    fun getByCollaboratorId(id: String): Collection<CollaboratorCoordinates>
}
