package lt.boldadmin.nexus.api.service.worklog.status

import lt.boldadmin.nexus.api.type.entity.Collaborator
import lt.boldadmin.nexus.api.type.entity.Project

interface WorklogStartEndService {
    fun getProjectOfStartedWork(collaboratorId: String): Project
    fun start(collaborator: Collaborator, project: Project)
    fun start(collaborator: Collaborator, project: Project, timestamp: Long)
    fun hasWorkStarted(collaboratorId: String): Boolean
    fun end(collaborator: Collaborator)
    fun end(collaborator: Collaborator, timestamp: Long)
    fun endAllStartedWorkWhereWorkTimeEnded()
    fun hasWorkEnded(collaboratorId: String): Boolean
}