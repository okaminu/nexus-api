package lt.boldadmin.nexus.api

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

interface ReverseGeocodeConverter {

    fun convertToAddress(coordinates: Coordinates): String

    fun convertToPlusCode(coordinates: Coordinates): String

}
