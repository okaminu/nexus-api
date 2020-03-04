package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.valueobject.location.Coordinates

interface ReverseGeocoder {

    fun toAddress(coordinates: Coordinates): String

    fun toPlusCode(coordinates: Coordinates): String

}
