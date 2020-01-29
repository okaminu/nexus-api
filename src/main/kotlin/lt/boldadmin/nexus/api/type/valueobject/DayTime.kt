package lt.boldadmin.nexus.api.type.valueobject

data class DayTime(
    val time: TimeRange = TimeRange(),
    val isEnabled: Boolean = false,
    val dayOfWeekIndex: Int = 0
): Comparable<DayTime> {

    override fun compareTo(other: DayTime): Int = this.dayOfWeekIndex.compareTo(other.dayOfWeekIndex)

    override fun equals(other: Any?): Boolean = other is DayTime && this.compareTo(other) == 0

    override fun hashCode(): Int = dayOfWeekIndex

}
