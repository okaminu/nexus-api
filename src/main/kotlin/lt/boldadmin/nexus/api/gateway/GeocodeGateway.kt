package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.valueobject.Location

interface GeocodeGateway {

    fun convert(address: String): Location
}