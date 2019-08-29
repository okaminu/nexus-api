package lt.boldadmin.nexus.api.service.worklog.status.location

import lt.boldadmin.nexus.api.type.valueobject.Coordinates

interface WorklogLocationService {
    fun logWork(collaboratorId: String, coordinates: Coordinates)
}