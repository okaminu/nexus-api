package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Project
import java.util.*

interface ProjectRepository {

    fun save(project: Project)

    fun findById(id: String): Project

    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Project>

}
