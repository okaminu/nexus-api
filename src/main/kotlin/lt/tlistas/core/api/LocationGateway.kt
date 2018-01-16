package lt.tlistas.core.api

import lt.tlistas.core.exception.LocationByAddressNotFoundException
import lt.tlistas.core.exception.LocationGatewayException
import lt.tlistas.core.type.Location

interface LocationGateway {

    @Throws(LocationByAddressNotFoundException::class, LocationGatewayException::class)
    fun convert(address: String): Location
}