package lt.boldadmin.nexus.api.type.entity.collaborator

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

class CollaboratorCoordinates(
    val collaboratorId: String = "",
    val coordinates: Coordinates = Coordinates(),
    val timestamp: Long = 123
)
