package lt.boldadmin.nexus.api.service.collaborator

import lt.boldadmin.nexus.api.type.valueobject.Day
import java.util.*

interface WeekValidatorService {
    fun validate(workWeek: SortedSet<Day>)
}
