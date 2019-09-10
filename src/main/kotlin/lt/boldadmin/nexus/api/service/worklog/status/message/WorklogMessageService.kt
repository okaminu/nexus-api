package lt.boldadmin.nexus.api.service.worklog.status.message

import lt.boldadmin.nexus.api.type.valueobject.Message

interface WorklogMessageService {
    fun logWork(message: Message)
}
