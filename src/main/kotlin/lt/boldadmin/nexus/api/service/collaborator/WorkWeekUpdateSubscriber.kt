package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.valueobject.DayMinuteInterval
import java.util.*

interface WorkWeekUpdateSubscriber {
    fun notifyBefore(collaboratorId: String, workWeek: SortedSet<DayMinuteInterval>)
}
