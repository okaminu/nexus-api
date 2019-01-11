package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Company

interface CompanyRepository {

    fun save(company: Company)

    fun existsByName(name: String): Boolean

}