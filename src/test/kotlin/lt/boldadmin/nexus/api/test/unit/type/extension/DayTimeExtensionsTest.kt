package lt.boldadmin.nexus.api.test.unit.type.extension

import lt.boldadmin.nexus.api.type.extension.get
import lt.boldadmin.nexus.api.type.valueobject.DayTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek.*

class DayTimeExtensionsTest{
    
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

}

