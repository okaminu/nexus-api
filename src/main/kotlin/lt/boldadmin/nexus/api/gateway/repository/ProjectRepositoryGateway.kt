package lt.boldadmin.nexus.api.gateway.repository

import lt.boldadmin.nexus.api.type.entity.Project
import java.util.*

interface ProjectRepositoryGateway {
    fun findByOrderNumberIsGreaterThanEqual(orderNumber: Short): Collection<Project>

    fun save(project: Project)

    fun findById(id: String): Project
}
