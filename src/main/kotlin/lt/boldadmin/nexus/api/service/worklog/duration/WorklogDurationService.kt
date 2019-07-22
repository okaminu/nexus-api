package lt.boldadmin.nexus.api.service.worklog.duration

interface WorklogDurationService {
    fun measureDuration(intervalId: String): Long
    fun sumWorkDurationsByCollaboratorId(collaboratorId: String): Long
    fun sumWorkDurationsByProjectId(projectId: String): Long
}
