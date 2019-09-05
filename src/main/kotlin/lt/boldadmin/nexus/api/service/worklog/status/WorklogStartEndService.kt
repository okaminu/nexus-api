package lt.boldadmin.nexus.api.service.worklog.status

import lt.boldadmin.nexus.api.type.entity.Project

interface WorklogStartEndService {
    fun getProjectOfStartedWork(collaboratorId: String): Project
    fun hasWorkStarted(collaboratorId: String): Boolean
    fun hasWorkStarted(collaboratorId: String, projectId: String): Boolean
    fun endAllStartedWorkWhereWorkTimeEnded()
}