package lt.boldadmin.nexus.api.type.valueobject

data class Message(
    val senderPhoneNumber: String,
    val collaboratorPhoneNumber: String,
    val content: String
)