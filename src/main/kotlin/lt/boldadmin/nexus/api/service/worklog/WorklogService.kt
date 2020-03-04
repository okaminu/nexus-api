package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Worklog
import lt.boldadmin.nexus.api.type.valueobject.time.DateInterval

interface WorklogService {
    fun save(worklog: Worklog)
    fun getIntervalEndpoints(intervalId: String): Collection<Worklog>
    fun getIntervalIdsByCollaboratorId(id: String): Collection<String>
    fun getIntervalIdsByCollaboratorId(id: String, dateInterval: DateInterval): Collection<String>
    fun getIntervalIdsByProjectId(id: String): Collection<String>
    fun getIntervalIdsByProjectId(id: String, dateInterval: DateInterval): Collection<String>
}
