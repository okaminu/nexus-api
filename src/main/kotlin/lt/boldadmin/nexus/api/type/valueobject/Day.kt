package lt.boldadmin.nexus.api.type.valueobject

import java.time.DayOfWeek
import java.time.DayOfWeek.MONDAY

data class Day(
    val minuteInterval: MinuteRange = MinuteRange(),
    val enabled: Boolean = false,
    val dayOfWeek: DayOfWeek = MONDAY
): Comparable<Day> {

    override fun compareTo(other: Day): Int = this.dayOfWeek.compareTo(other.dayOfWeek)

    override fun equals(other: Any?): Boolean = other is Day && this.compareTo(other) == 0

    override fun hashCode(): Int = dayOfWeek.ordinal

}
