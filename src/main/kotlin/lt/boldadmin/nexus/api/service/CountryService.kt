package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.valueobject.Country

interface CountryService {
    val countries: Collection<Country>
}
