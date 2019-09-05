package lt.boldadmin.nexus.api.event.subscriber

import lt.boldadmin.nexus.api.type.valueobject.Coordinates
import lt.boldadmin.nexus.api.type.valueobject.Message

interface CollaboratorLocationSubscriber {
    fun subscribe(subscription: (collabId: String, coordinates: Coordinates) -> Unit)
    fun subscribe(subscription: (message: Message) -> Unit)
}