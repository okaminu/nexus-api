package lt.boldadmin.nexus.api

interface SmsGateway {
    fun send(senderPhoneNumber: String, receiverPhoneNumber: String, message: String)
}