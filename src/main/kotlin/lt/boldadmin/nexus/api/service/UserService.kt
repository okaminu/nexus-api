package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.User

interface UserService {
    fun save(user: User)
    fun createWithDefaults(): User
    fun getById(id: String): User
    fun getByEmail(email: String): User?
    fun doesUserHaveCustomer(userId: String, customerId: String): Boolean
    fun doesUserHaveProject(userId: String, projectId: String): Boolean
    fun doesUserHaveCollaborator(userId: String, collaboratorId: String): Boolean
    fun isProjectNameUnique(projectName: String, userId: String): Boolean
    fun getByProjectId(projectId: String): User
}