package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.StartedProjectWorkToken

interface StartedProjectWorkTokenRepository {

    fun save(workToken: StartedProjectWorkToken)

    fun findById(id: String): StartedProjectWorkToken

    fun findByToken(token: String): StartedProjectWorkToken

    fun existsById(id: String): Boolean

    fun existsByToken(token: String): Boolean

    fun deleteById(id: String)

}