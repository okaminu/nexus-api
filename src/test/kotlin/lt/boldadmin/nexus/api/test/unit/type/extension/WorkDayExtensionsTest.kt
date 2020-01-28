package lt.boldadmin.nexus.api.test.unit.type.extension

import lt.boldadmin.nexus.api.type.extension.get
import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek.*

class WorkDayExtensionsTest{
    
    @Test
    fun `Sorted work days can be retrieved by day`() {
        val firstWorkDay = WorkDay(day = MONDAY.ordinal)
        val secondWorkDay = WorkDay(day = TUESDAY.ordinal)
        val workDays = sortedSetOf(secondWorkDay, firstWorkDay)

        assertEquals(secondWorkDay, workDays[TUESDAY])
    }

    @Test
    fun `Throws exception if queried day is not found`() {
        assertThrows<NoSuchElementException> {
            sortedSetOf(WorkDay(day = WEDNESDAY.ordinal))[MONDAY]
        }
    }

}

