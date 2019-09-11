package lt.boldadmin.nexus.api.service.worklog

interface WorklogAuthService {
    fun doesUserHaveWorkLogInterval(userId: String, intervalId: String): Boolean
    fun doesCollaboratorHaveWorkLogInterval(collaboratorId: String, intervalId: String): Boolean
    fun doesCollaboratorHaveWorkLogIntervals(collaboratorId: String, intervalIds: Collection<String>): Boolean
}
