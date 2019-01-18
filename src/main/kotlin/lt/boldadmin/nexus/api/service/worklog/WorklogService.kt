package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Worklog

interface WorklogService {
    fun save(worklog: Worklog)
    fun getByCollaboratorId(id: String): Collection<Worklog>
    fun getByProjectId(id: String): Collection<Worklog>
    fun getIntervalEndpoints(intervalId: String): Collection<Worklog>
    fun existsByProjectIdAndCollaboratorId(projectId: String, collaboratorId: String): Boolean
}