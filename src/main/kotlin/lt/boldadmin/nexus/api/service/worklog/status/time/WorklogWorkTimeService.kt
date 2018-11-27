package lt.boldadmin.nexus.api.service.worklog.status.time

import lt.boldadmin.nexus.api.type.valueobject.TimeRange

interface WorklogWorkTimeService {

    fun logWork(collaboratorId: String, workTime: TimeRange)

}