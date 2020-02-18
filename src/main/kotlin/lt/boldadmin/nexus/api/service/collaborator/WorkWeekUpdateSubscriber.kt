package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.valueobject.time.DayMinuteInterval
import java.util.*

interface WorkWeekUpdateSubscriber {
    fun notifyBefore(collaboratorId: String, workWeek: SortedSet<DayMinuteInterval>)
}
