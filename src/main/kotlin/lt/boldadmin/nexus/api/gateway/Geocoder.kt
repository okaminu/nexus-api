package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

interface Geocoder {

    fun toCoordinates(address: String): Coordinates

}
