package lt.tlistas.core.api

import lt.tlistas.core.api.type.Location

interface GeocodeGateway {

    fun convert(address: String): Location
}