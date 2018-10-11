package lt.boldadmin.nexus.api

interface SmsGateway {
    fun send(phoneNumber: String, message: String)
}