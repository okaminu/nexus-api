package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.valueobject.Coordinates
import java.time.ZoneId

interface TimeZoneConverter {

    fun convert(coordinates: Coordinates): ZoneId

}
