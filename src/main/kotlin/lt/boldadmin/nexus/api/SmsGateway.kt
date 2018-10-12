package lt.boldadmin.nexus.api

interface SmsGateway {
    fun send(fromPhoneNumber: String, toPhoneNumber: String, message: String)
}