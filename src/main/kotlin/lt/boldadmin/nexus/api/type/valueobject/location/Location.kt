package lt.boldadmin.nexus.api.type.valueobject.location

data class Location(val coordinates: Coordinates = Coordinates(), val radiusInMeters: Int = 0)
