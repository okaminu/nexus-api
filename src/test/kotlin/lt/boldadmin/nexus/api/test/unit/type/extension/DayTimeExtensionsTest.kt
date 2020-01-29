package lt.boldadmin.nexus.api.test.unit.type.extension

import lt.boldadmin.nexus.api.type.extension.*
import lt.boldadmin.nexus.api.type.valueobject.DayTime
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek.*
import java.util.*

class DayTimeExtensionsTest {

    @Test
    fun `Sorted day times can be retrieved by day`() {
        val firstWorkDay = DayTime(dayOfWeekIndex = MONDAY.ordinal)
        val secondWorkDay = DayTime(dayOfWeekIndex = TUESDAY.ordinal)
        val workDays = sortedSetOf(secondWorkDay, firstWorkDay)

        assertEquals(secondWorkDay, workDays[TUESDAY])
    }

    @Test
    fun `Throws exception if queried day is not found`() {
        assertThrows<NoSuchElementException> {
            sortedSetOf(DayTime(dayOfWeekIndex = WEDNESDAY.ordinal))[MONDAY]
        }
    }

    @Test
    fun `Creates a sorted set of 7 day times`() {
        val timeRange = TimeRange(100, 300)

        val sortedDayTimes: SortedSet<DayTime> = createSortedDaysOfWeek(timeRange)

        assertEquals(7, sortedDayTimes.size)
        assertEquals(timeRange, sortedDayTimes[FRIDAY].time)
    }

    @Test
    fun `Sorted day times contain incremented day values`() {
        val sortedWorkDays = createSortedDaysOfWeek(TimeRange(100, 300))

        assertEquals(4, sortedWorkDays[FRIDAY].dayOfWeekIndex)
    }

    @Test
    fun `Changes desired day times to enabled state`() {
        val timeRange = TimeRange(100, 300)

        val sortedDayTimes: SortedSet<DayTime> = createSortedDaysOfWeek(timeRange).setEnabled(FRIDAY, SUNDAY)

        assertTrue(sortedDayTimes[FRIDAY].isEnabled)
        assertTrue(sortedDayTimes[SUNDAY].isEnabled)
        assertFalse(sortedDayTimes[THURSDAY].isEnabled)
        assertEquals(timeRange, sortedDayTimes[FRIDAY].time)
        assertEquals(timeRange, sortedDayTimes[SUNDAY].time)
    }

    @Test
    fun `Changes desired day times to disabled state`() {
        val timeRange = TimeRange(100, 300)

        val sortedDayTimes: SortedSet<DayTime> =
            sortedSetOf(
                DayTime(timeRange, false, MONDAY.ordinal),
                DayTime(timeRange, true, TUESDAY.ordinal),
                DayTime(timeRange, true, WEDNESDAY.ordinal)
            ).setDisabled(TUESDAY, WEDNESDAY)

        assertFalse(sortedDayTimes[TUESDAY].isEnabled)
        assertFalse(sortedDayTimes[WEDNESDAY].isEnabled)
        assertEquals(timeRange, sortedDayTimes[TUESDAY].time)
        assertEquals(timeRange, sortedDayTimes[WEDNESDAY].time)
    }

    @Test
    fun `Changes desired day time`() {
        val timeRange = TimeRange(100, 300)
        val newTimeRange = TimeRange(400, 600)

        val sortedDayTimes: SortedSet<DayTime> = createSortedDaysOfWeek(timeRange).setTime(newTimeRange, FRIDAY)

        assertEquals(newTimeRange, sortedDayTimes[FRIDAY].time)
        assertEquals(sortedDayTimes[THURSDAY].isEnabled, sortedDayTimes[FRIDAY].isEnabled)
    }

}

