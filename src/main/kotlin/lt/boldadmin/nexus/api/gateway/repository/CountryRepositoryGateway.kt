package lt.boldadmin.nexus.api.gateway.repository

import lt.boldadmin.nexus.api.type.valueobject.Country


interface CountryRepositoryGateway {

    fun findAll(): Collection<Country>

}