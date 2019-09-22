package lt.boldadmin.nexus.api

interface ReverseGeocodeConverter {

    fun convertToAddress(latitude: Double, longitude: Double): String

    fun convertToPlusCode(latitude: Double, longitude: Double): String

}
