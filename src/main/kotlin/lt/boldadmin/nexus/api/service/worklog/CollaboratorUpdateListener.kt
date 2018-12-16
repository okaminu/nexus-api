package lt.boldadmin.nexus.api.service.worklog

import lt.boldadmin.nexus.api.type.entity.Collaborator

interface CollaboratorUpdateListener {
    fun run(collaborator: Collaborator, attributeName: String, attributeValue: String)
}