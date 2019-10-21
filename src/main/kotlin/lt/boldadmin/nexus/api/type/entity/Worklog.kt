package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.entity.collaborator.Collaborator
import lt.boldadmin.nexus.api.type.valueobject.WorkStatus

data class Worklog(

    val project: Project = Project(),

    val collaborator: Collaborator = Collaborator(),

    val timestamp: Long = 0,

    val workStatus: WorkStatus = WorkStatus.START,

    val intervalId: String = "",

    var id: String = ""
)
