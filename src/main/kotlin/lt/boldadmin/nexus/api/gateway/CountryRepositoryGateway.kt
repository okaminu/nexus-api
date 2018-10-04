package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.valueobject.Country


interface CountryRepositoryGateway {

    fun findAll(): Collection<Country>

}