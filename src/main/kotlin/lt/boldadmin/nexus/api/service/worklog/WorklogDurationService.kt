package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.valueobject.time.DateInterval

interface WorklogDurationService {
    fun measureDuration(intervalId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String): Long
    fun sumWorkDurationsByProjectId(projectId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String, dateInterval: DateInterval): Long
    fun sumWorkDurationsByProjectId(projectId: String, dateInterval: DateInterval): Long
}
