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

fun SortedSet<DayTime>.setEnabled(vararg days: DayOfWeek) = changeEnabledStatus(true, *days)

fun SortedSet<DayTime>.setDisabled(vararg days: DayOfWeek) = changeEnabledStatus(false, *days)

fun SortedSet<DayTime>.setTime(time: TimeRange, day: DayOfWeek) =
    this.toMutableList().apply {
        this[day.ordinal] = this[day.ordinal].copy(time = time)
    }.toSortedSet()

private fun SortedSet<DayTime>.changeEnabledStatus(isEnabled: Boolean, vararg days: DayOfWeek): SortedSet<DayTime> =
    this.toMutableList().apply {
        days.forEach { day ->
            this[day.ordinal] = this[day.ordinal].copy(isEnabled = isEnabled)
        }
    }.toSortedSet()
