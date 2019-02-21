package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Worklog

interface WorklogRepository {

    fun save(worklog: Worklog)

    fun findByProjectId(projectId: String): Collection<Worklog>

    fun findByCollaboratorId(collaboratorId: String): Collection<Worklog>

    fun findByIntervalIdOrderByLatest(intervalId: String): Collection<Worklog>

    fun findLatest(intervalId: String): Worklog?

    fun findLatest(collaboratorId: String, projectId: String): Worklog?

    fun doesUserHaveWorklogInterval(userId: String, intervalId: String): Boolean

    fun doesCollaboratorHaveWorklogInterval(collaboratorId: String, intervalId: String): Boolean

    fun doesCollaboratorHaveWorklogIntervals(collaboratorId: String, intervalIds: Collection<String>): Boolean

}
