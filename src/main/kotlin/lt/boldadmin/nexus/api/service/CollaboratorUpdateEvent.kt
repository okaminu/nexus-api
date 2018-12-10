package lt.boldadmin.nexus.api.service

import lt.boldadmin.nexus.api.type.entity.Collaborator

interface CollaboratorUpdateEvent {
    fun run(collaborator: Collaborator, attributeName: String, attributeValue: String)
}