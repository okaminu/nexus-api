package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.valueobject.DayMinuteInterval
import lt.boldadmin.nexus.api.type.valueobject.WeekConstraintViolation
import java.util.*

interface WorkWeekValidatorService {
    fun validate(workWeek: SortedSet<DayMinuteInterval>): Set<WeekConstraintViolation>
}
