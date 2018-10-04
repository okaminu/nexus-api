package lt.boldadmin.nexus.api.gateway

import lt.boldadmin.nexus.api.type.entity.User
import java.util.*

interface UserRepositoryGateway  {
    fun findByEmail(email: String): User?

    fun findById(id: String): Optional<User>

    fun save(user: User)

    fun findAll(): Collection<User>
}
