package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Collaborator
import lt.boldadmin.nexus.api.type.entity.User

interface UserService {
    fun save(user: User)
    fun createWithDefaults(): User
    fun getById(id: String): User
    fun getByEmail(email: String): User
    fun existsByCompanyName(name: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun existsAny(): Boolean
    fun getByProjectId(projectId: String): User
    fun getByCollaboratorId(collaboratorId: String): User
    fun getCollaborators(userId: String): Set<Collaborator>
    fun doesUserHaveProject(userId: String, projectId: String): Boolean
    fun doesUserHaveCollaborator(userId: String, collaboratorId: String): Boolean
    fun isProjectNameUnique(projectName: String, projectId: String, userId: String): Boolean
}
