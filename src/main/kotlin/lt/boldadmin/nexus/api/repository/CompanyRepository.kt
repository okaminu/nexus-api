package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.Company

interface CompanyRepository {

    fun save(company: Company)

    fun findByName(name: String): Company?

}