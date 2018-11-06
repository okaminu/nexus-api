package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Worklog

interface WorkLogService {
    fun getByCollaboratorId(id: String): Collection<Worklog>
    fun getByProjectId(id: String): Collection<Worklog>
    fun getIntervalEndpoints(intervalId: String): Collection<Worklog>
}