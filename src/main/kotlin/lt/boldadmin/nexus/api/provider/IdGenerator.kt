package lt.boldadmin.nexus.api.provider

interface IdGenerator {

    fun generateUniqueId(isUnique: (id: String) -> Boolean): String

}