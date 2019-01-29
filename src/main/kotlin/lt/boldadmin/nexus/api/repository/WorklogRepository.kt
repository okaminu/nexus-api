package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Worklog
import lt.boldadmin.nexus.api.type.valueobject.WorkStatus

interface WorklogRepository {

    fun save(worklog: Worklog)


    fun findById(id: String): Worklog

    fun findByProjectId(projectId: String): Collection<Worklog>

    fun findByIntervalId(intervalId: String): Collection<Worklog>

    fun findByCollaboratorId(collaboratorId: String): Collection<Worklog>

    fun findFirstByIntervalId(intervalId: String): Worklog

    fun findByIntervalIdAndWorkStatusNotOrderByLatest(intervalId: String, workStatus: WorkStatus)
        : Collection<Worklog>

    fun findLatestByCollaboratorIdAndWorkStatusNot(collaboratorId: String, workStatus: WorkStatus): Worklog?

    fun findLatestByProjectIdAndCollaboratorIdAndWorkStatusNot(
        projectId: String,
        collaboratorId: String,
        workStatus: WorkStatus
    ): Worklog?

    fun findLatestByIntervalIdAndWorkStatus(intervalId: String, workStatus: WorkStatus): Worklog?

    fun existsByIntervalId(intervalId: String): Boolean

    fun doesUserHaveWorklogInterval(userId: String, intervalId: String): Boolean

    fun doesCollaboratorHaveWorklogInterval(collaboratorId: String, intervalId: String): Boolean

    fun doesCollaboratorHaveWorklogIntervals(collaboratorId: String, intervalIds: Collection<String>): Boolean

}