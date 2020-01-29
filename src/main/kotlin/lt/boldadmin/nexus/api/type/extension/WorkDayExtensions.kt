package lt.boldadmin.nexus.api.type.extension

import lt.boldadmin.nexus.api.type.valueobject.DayTime
import java.time.DayOfWeek
import java.util.*
import kotlin.NoSuchElementException

operator fun SortedSet<DayTime>.get(day: DayOfWeek): DayTime =
    this.find { it.dayOfWeekIndex == day.ordinal } ?: throw NoSuchElementException()
