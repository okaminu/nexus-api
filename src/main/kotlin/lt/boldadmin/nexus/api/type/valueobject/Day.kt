package lt.boldadmin.nexus.api.type.valueobject

data class Day(
    val minuteRange: MinuteRange = MinuteRange(),
    val enabled: Boolean = false,
    val dayOfWeekIndex: Int = 0
): Comparable<Day> {

    override fun compareTo(other: Day): Int = this.dayOfWeekIndex.compareTo(other.dayOfWeekIndex)

    override fun equals(other: Any?): Boolean = other is Day && this.compareTo(other) == 0

    override fun hashCode(): Int = dayOfWeekIndex

}
