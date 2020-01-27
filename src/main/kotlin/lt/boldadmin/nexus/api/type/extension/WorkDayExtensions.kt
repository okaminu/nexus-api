package lt.boldadmin.nexus.api.type.extension

import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import java.util.*
import kotlin.NoSuchElementException

operator fun SortedSet<WorkDay>.get(day: Int): WorkDay = this.find { it.day == day } ?: throw NoSuchElementException()
