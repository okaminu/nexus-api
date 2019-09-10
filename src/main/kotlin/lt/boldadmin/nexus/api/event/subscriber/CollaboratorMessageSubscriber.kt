package lt.boldadmin.nexus.api.event.subscriber

import lt.boldadmin.nexus.api.type.valueobject.Message

interface CollaboratorMessageSubscriber {
    fun notify(message: Message)
}