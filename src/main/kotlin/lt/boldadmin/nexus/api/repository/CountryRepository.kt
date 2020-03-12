package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.valueobject.location.Country

interface CountryRepository {

    fun findAll(): Collection<Country>

}
