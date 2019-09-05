package lt.boldadmin.nexus.api.event.publisher

import lt.boldadmin.nexus.api.type.valueobject.Coordinates
import lt.boldadmin.nexus.api.type.valueobject.Message

interface CollaboratorLocationPublisher {
    fun publish(collaboratorId: String, coordinates: Coordinates)
    fun publish(message: Message)
}