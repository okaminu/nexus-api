package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Company

interface CompanyService {
    fun save(company: Company)
    fun getByName(name: String): Company?
}