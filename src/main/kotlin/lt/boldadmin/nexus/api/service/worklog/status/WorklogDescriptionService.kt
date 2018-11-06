package lt.boldadmin.nexus.api.service.worklog.status

interface WorklogDescriptionService {
    fun getDescription(intervalId: String): String
    fun updateDescription(intervalId: String, description: String)
    fun updateDescriptionByCollaboratorId(collaboratorId: String, description: String)
}