package lt.boldadmin.nexus.api.event.publisher

import lt.boldadmin.nexus.api.type.valueobject.location.Coordinates

interface CollaboratorCoordinatesPublisher {
    fun publish(collaboratorId: String, coordinates: Coordinates)
    fun publishAbsent(collaboratorId: String)
}
