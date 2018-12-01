package lt.boldadmin.nexus.api.service

interface CollaboratorUpdate {
    fun run(collaboratorId: String, attributeName: String, attributeValue: String)
}