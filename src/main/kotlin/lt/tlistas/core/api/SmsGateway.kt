package lt.tlistas.core.api

interface SmsGateway {
    fun send(message: String, mobileNumber: String)
}