package lt.boldadmin.nexus.api

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

interface ReverseGeocodeGateway {

    fun convertToAddress(coordinates: Coordinates): String

    fun convertToPlusCode(coordinates: Coordinates): String

}