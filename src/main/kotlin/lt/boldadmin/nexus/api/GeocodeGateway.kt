package lt.boldadmin.nexus.api

import lt.boldadmin.nexus.api.type.valueobject.Location

interface GeocodeGateway {

    fun convert(address: String): Location
}