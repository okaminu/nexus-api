package lt.boldadmin.nexus.api

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

interface ReverseGeocoder {

    fun toAddress(coordinates: Coordinates): String

    fun toPlusCode(coordinates: Coordinates): String

}
