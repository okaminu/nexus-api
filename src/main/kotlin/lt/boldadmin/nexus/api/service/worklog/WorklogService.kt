package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Worklog
import lt.boldadmin.nexus.api.type.valueobject.DateRange

interface WorklogService {
    fun save(worklog: Worklog)
    fun getIntervalEndpoints(intervalId: String): Collection<Worklog>
    fun getIntervalIdsByCollaboratorId(id: String): Collection<String>
    fun getIntervalIdsByCollaboratorId(id: String, dateRange: DateRange): Collection<String>
    fun getIntervalIdsByProjectId(id: String): Collection<String>
    fun getIntervalIdsByProjectId(id: String, dateRange: DateRange): Collection<String>
}
