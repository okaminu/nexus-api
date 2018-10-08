package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Company

interface CompanyRepository {

    fun findByName(name: String): Company?

    fun save(company: Company)

}