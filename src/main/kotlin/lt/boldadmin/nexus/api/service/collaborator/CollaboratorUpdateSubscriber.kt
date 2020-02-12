package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.entity.Collaborator
import lt.boldadmin.nexus.api.type.valueobject.Day
import java.util.*

interface CollaboratorUpdateSubscriber {
    fun notifyBefore(collaborator: Collaborator, attributeValue: SortedSet<Day>)
}
