package lt.boldadmin.nexus.api.type.valueobject

import java.time.DayOfWeek

data class DayMinuteInterval(
    val dayOfWeek: DayOfWeek,
    val interval: MinuteInterval,
    val enabled: Boolean
): Comparable<DayMinuteInterval> {

    override fun compareTo(other: DayMinuteInterval): Int = this.dayOfWeek.compareTo(other.dayOfWeek)

    override fun equals(other: Any?): Boolean = other is DayMinuteInterval && this.compareTo(other) == 0

    override fun hashCode(): Int = dayOfWeek.ordinal

}
