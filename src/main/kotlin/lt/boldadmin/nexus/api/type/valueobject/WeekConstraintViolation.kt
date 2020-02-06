package lt.boldadmin.nexus.api.type.valueobject

import java.time.DayOfWeek

class WeekConstraintViolation(var message: String = "", var dayOfWeek: DayOfWeek = DayOfWeek.MONDAY)
