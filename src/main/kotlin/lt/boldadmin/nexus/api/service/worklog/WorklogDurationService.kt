package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.valueobject.time.DateRange

interface WorklogDurationService {
    fun measureDuration(intervalId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String): Long
    fun sumWorkDurationsByProjectId(projectId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String, dateRange: DateRange): Long
    fun sumWorkDurationsByProjectId(projectId: String, dateRange: DateRange): Long
}
