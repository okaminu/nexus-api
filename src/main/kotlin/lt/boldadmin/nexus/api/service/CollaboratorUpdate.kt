package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Collaborator

interface CollaboratorUpdate {
    fun run(collaborator: Collaborator, attributeName: String, attributeValue: String)
}