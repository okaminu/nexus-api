package lt.boldadmin.nexus.api.gateway

interface SmsGateway {
    fun send(senderPhoneNumber: String, receiverPhoneNumber: String, message: String)
}
