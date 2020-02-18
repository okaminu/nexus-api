package lt.boldadmin.nexus.api.type.valueobject.location

data class CollaboratorCoordinates(
    val collaboratorId: String = "",
    val coordinates: Coordinates = Coordinates(),
    val timestamp: Long = 0
)
