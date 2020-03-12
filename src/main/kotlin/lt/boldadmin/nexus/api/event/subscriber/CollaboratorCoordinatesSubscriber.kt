package lt.boldadmin.nexus.api.event.subscriber

import lt.boldadmin.nexus.api.type.valueobject.location.Coordinates

interface CollaboratorCoordinatesSubscriber {
    fun notify(collaboratorId: String, coordinates: Coordinates)
    fun notifyAbsent(collaboratorId: String)
}
