package lt.boldadmin.nexus.api.type.valueobject

import java.time.DayOfWeek

data class WeekConstraintViolation(val message: String, val dayOfWeek: DayOfWeek)
