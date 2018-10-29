package lt.boldadmin.nexus.api.type.entity

import lt.boldadmin.nexus.api.type.valueobject.WorkStatus

class Worklog(

    val project: Project,

    val collaborator: Collaborator,

    val timestamp: Long,

    val workStatus: WorkStatus,

    val intervalId: String,

    val description: String = "",

    var id: String? = null
)