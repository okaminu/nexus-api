package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.entity.Company

interface CompanyRepositoryGateway {

    fun findByName(name: String): Company?

    fun save(company: Company)

}