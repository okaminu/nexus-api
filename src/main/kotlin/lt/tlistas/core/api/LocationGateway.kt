package lt.tlistas.core.api

import lt.tlistas.core.type.Location

interface LocationGateway {
    fun convert(address: String): Location
}