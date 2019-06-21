package lt.boldadmin.nexus.api.type.valueobject

data class Location (val coordinates: Coordinates = Coordinates(), val radiusInMeters: Int = 70)