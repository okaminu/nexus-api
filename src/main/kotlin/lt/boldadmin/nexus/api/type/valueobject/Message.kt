package lt.boldadmin.nexus.api.type.valueobject

data class Message(
    val senderPhoneNumber: String,
    val collaboratorMobileNumber: String,
    val projectName: String? = null,
    val description: String? = null
)