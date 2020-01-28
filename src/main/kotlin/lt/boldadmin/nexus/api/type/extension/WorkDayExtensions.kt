package lt.boldadmin.nexus.api.type.extension

import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import java.time.DayOfWeek
import java.util.*
import kotlin.NoSuchElementException

operator fun SortedSet<WorkDay>.get(day: DayOfWeek): WorkDay =
    this.find { it.day == day.ordinal } ?: throw NoSuchElementException()
