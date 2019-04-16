package lt.boldadmin.nexus.api.type.entity

import java.util.*
import javax.validation.constraints.Size

class User(

    @field:Size(min = 1, message = "Last name required")
    var lastName: String = "",

    @field:Size(min = 8, message = "Password should contain at least 8 symbols")
    var password: String = "",

    var role: String = "",

    @field:Size(min = 1, message = "Company name required")
    var companyName: String = "",

    var projects: MutableCollection<Project> = HashSet(),

    var collaborators: MutableCollection<Collaborator> = HashSet()


) : Person() {
    fun addProject(project: Project) {
        projects.add(project)
    }

    fun addCollaborator(collaborator: Collaborator) {
        collaborators.add(collaborator)
    }
}
