package lt.boldadmin.nexus.api.service.worklog.status.location

import lt.boldadmin.nexus.api.type.entity.Collaborator
import lt.boldadmin.nexus.api.type.valueobject.Location

interface WorklogLocationService {
    fun logWork(collaborator: Collaborator, collaboratorLocation: Location)
}