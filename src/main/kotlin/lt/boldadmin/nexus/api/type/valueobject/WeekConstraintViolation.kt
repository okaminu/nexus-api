package lt.boldadmin.nexus.api.type.valueobject

import java.time.DayOfWeek

class WeekConstraintViolation(val message: String, val dayOfWeek: DayOfWeek) {

    override fun equals(other: Any?): Boolean = other is WeekConstraintViolation && this.dayOfWeek == other.dayOfWeek

    override fun hashCode(): Int = dayOfWeek.ordinal.hashCode()

}
