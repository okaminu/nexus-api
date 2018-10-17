package lt.boldadmin.nexus.api.type.valueobject

data class Message(
    val senderContactNumber: String,
    val collaboratorContactNumber: String,
    val content: String
)