package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Project
import lt.boldadmin.nexus.api.type.entity.User
import lt.boldadmin.nexus.api.type.entity.Worklog
import java.util.*

interface UserRepository  {

    fun save(user: User)


    fun findAll(): Collection<User>

    fun findById(id: String): User

    fun findByEmail(email: String): User?

    fun findByCollaboratorId(collaboratorId: String): User

    fun findByProjectId(projectId: String): User

    fun findProjectByUserId(userId: String): Set<Project>

    fun doesUserHaveCustomer(userId: String, customerId: String): Boolean

    fun doesUserHaveProject(userId: String, projectId: String): Boolean

    fun doesUserHaveCollaborator(userId: String, collaboratorId: String): Boolean

    fun doesUserHaveWorklog(userId: String, worklog: Worklog): Boolean

    fun isProjectNameUnique(projectName: String, projectId: String, userId: String): Boolean

}
