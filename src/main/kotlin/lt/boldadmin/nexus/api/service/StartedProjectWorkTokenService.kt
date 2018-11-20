package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Project

interface StartedProjectWorkTokenService {
    fun generateAndStore(projectId: String) {}
    fun findTokenById(projectId: String): String
    fun findIdByToken(token: String): String
    fun findProjectByToken(token: String): Project
    fun findWorkingCollaboratorIdsByToken(token: String): List<String?>
    fun existsById(projectId: String): Boolean
    fun deleteById(projectId: String) {}
}