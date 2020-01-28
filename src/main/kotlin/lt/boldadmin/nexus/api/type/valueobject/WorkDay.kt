package lt.boldadmin.nexus.api.type.valueobject

data class WorkDay(
    val time: TimeRange = TimeRange(),
    val isEnabled: Boolean = false,
    val day: Int = 0
): Comparable<WorkDay> {

    override fun compareTo(other: WorkDay): Int = this.day.compareTo(other.day)

    override fun equals(other: Any?): Boolean = other is WorkDay && this.compareTo(other) == 0

    override fun hashCode(): Int = day

}
