package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.WorkLog
import lt.boldadmin.nexus.api.type.valueobject.WorkStatus

interface WorkLogRepository  {
    fun findLatestIntervalEnpointByCollaboratorId(collaboratorId: String, workStatus: WorkStatus)
        : WorkLog?

    fun findByCollaboratorId(collaboratorId: String): Collection<WorkLog>

    fun findByProjectId(projectId: String): Collection<WorkLog>

    fun existsByIntervalId(intervalId: String): Boolean

    fun findByIntervalId(intervalId: String): Collection<WorkLog>

    fun findIntervalEndpointsAsc(intervalId: String, workStatus: WorkStatus)
        : Collection<WorkLog>

    fun findLatestIntervalEnpointByIntervalId(intervalId: String, workStatus: WorkStatus): WorkLog?

    fun findFirstByIntervalId(intervalId: String): WorkLog

    fun save(workLog: WorkLog)

    fun findById(id: String): WorkLog
}