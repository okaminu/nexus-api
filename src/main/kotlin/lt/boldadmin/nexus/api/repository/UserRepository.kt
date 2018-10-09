package lt.boldadmin.nexus.api.repository

import lt.boldadmin.nexus.api.type.entity.User
import java.util.*

interface UserRepository  {

    fun save(user: User)


    fun findAll(): Collection<User>

    fun findById(id: String): User

    fun findByEmail(email: String): User?

}
