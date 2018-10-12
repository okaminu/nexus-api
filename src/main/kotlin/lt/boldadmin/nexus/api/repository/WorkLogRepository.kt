package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.WorkLog
import lt.boldadmin.nexus.api.type.valueobject.WorkStatus

interface WorkLogRepository  {

    fun save(workLog: WorkLog)


    fun findById(id: String): WorkLog

    fun findByProjectId(projectId: String): Collection<WorkLog>

    fun findByIntervalId(intervalId: String): Collection<WorkLog>

    fun findByCollaboratorId(collaboratorId: String): Collection<WorkLog>

    fun findFirstByIntervalId(intervalId: String): WorkLog

    fun findByIntervalIdAndWorkStatusNotOrderByLatest(intervalId: String, workStatus: WorkStatus)
        : Collection<WorkLog>

    fun findLatestByCollaboratorIdAndWorkStatusNot(collaboratorId: String, workStatus: WorkStatus): WorkLog?

    fun findLatestByIntervalIdAndWorkStatus(intervalId: String, workStatus: WorkStatus): WorkLog?


    fun existsByIntervalId(intervalId: String): Boolean

}