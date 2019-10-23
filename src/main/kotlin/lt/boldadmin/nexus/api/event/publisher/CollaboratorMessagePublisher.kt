package lt.boldadmin.nexus.api.event.publisher

import lt.boldadmin.nexus.api.type.valueobject.Message

interface CollaboratorMessagePublisher {
    fun publish(message: Message)
}
