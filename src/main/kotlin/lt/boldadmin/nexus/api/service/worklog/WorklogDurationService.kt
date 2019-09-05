package lt.boldadmin.nexus.api.service.worklog

interface WorklogDurationService {
    fun measureDuration(intervalId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String): Long
    fun sumWorkDurationsByProjectId(projectId: String): Long
}