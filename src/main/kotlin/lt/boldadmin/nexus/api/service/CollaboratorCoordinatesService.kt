package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.CollaboratorCoordinates

interface CollaboratorCoordinatesService {
    fun getByCollaboratorId(id: String): Collection<CollaboratorCoordinates>
}
