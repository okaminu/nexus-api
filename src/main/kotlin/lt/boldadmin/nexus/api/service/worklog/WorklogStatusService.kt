package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Project

interface WorklogStatusService {
    fun getProjectOfStartedWork(collaboratorId: String): Project
    fun hasWorkStarted(collaboratorId: String): Boolean
    fun hasWorkStarted(collaboratorId: String, projectId: String): Boolean
    fun endAllStartedWorkWhereWorkTimeEnded()
}
