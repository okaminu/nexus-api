package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.entity.WorkLog
import lt.boldadmin.nexus.api.type.valueobject.WorkStatus
import java.util.*

interface WorkLogRepositoryGateway  {
    fun findFirstByCollaboratorIdAndWorkStatusNotOrderByTimestampDesc(collaboratorId: String, workStatus: WorkStatus)
        : WorkLog?

    fun findByCollaboratorId(collaboratorId: String): Collection<WorkLog>

    fun findByProjectId(projectId: String): Collection<WorkLog>

    fun existsByIntervalId(intervalId: String): Boolean

    fun findByIntervalId(intervalId: String): Collection<WorkLog>

    fun findByIntervalIdAndWorkStatusNotOrderByTimestampAsc(intervalId: String, workStatus: WorkStatus)
        : Collection<WorkLog>

    fun findFirstByIntervalIdAndWorkStatusOrderByTimestampDesc(intervalId: String, workStatus: WorkStatus): WorkLog?

    fun findFirstByIntervalId(intervalId: String): WorkLog

    fun save(workLog: WorkLog)

    fun findById(id: String): WorkLog
}