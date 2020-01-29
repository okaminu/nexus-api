package lt.boldadmin.nexus.api.type.extension

import lt.boldadmin.nexus.api.type.valueobject.DayTime
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import java.time.DayOfWeek
import java.util.*
import kotlin.NoSuchElementException

fun createSortedDaysOfWeek(time: TimeRange) =
    DayOfWeek.values().map {
        DayTime(time, false, it.ordinal)
    }.toSortedSet()

operator fun SortedSet<DayTime>.get(day: DayOfWeek): DayTime =
    this.find { it.dayOfWeekIndex == day.ordinal } ?: throw NoSuchElementException()

fun SortedSet<DayTime>.withEnabled(vararg days: DayOfWeek) = withEnabledStatus(true, *days)

fun SortedSet<DayTime>.withDisabled(vararg days: DayOfWeek) = withEnabledStatus(false, *days)

fun SortedSet<DayTime>.withTime(time: TimeRange, day: DayOfWeek) =
    this.toMutableList().apply {
        this[day.ordinal] = this[day.ordinal].copy(time = time)
    }.toSortedSet()

private fun SortedSet<DayTime>.withEnabledStatus(isEnabled: Boolean, vararg days: DayOfWeek): SortedSet<DayTime> =
    this.toMutableList().apply {
        days.forEach { day ->
            this[day.ordinal] = this[day.ordinal].copy(isEnabled = isEnabled)
        }
    }.toSortedSet()
