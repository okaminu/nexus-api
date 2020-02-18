package lt.boldadmin.nexus.api.type.valueobject.location

import lt.boldadmin.nexus.api.type.valueobject.location.Coordinates

data class Location(val coordinates: Coordinates = Coordinates(), val radiusInMeters: Int = 0)
