package lt.boldadmin.nexus.api.type.entity

import java.util.*
import javax.validation.constraints.Min

class Customer(

    val projects: HashSet<Project> = HashSet(),

    var organizationNumber: String = "",

    var mobileNumber: String = "",

    @field:Min(0)
    var orderNumber: Short = 0

) : Person() {

    fun addProject(project: Project) {
        projects.add(project)
    }

    fun incrementOrderNumber() {
        this.orderNumber++
    }
}

