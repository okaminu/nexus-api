package lt.boldadmin.nexus.api.test.unit.type.extension

import lt.boldadmin.nexus.api.type.extension.get
import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorkDayExtensionsTest{
    
    @Test
    fun `Sorted work days can be retrieved by day`() {
        val firstWorkDay = WorkDay(day = 1)
        val secondWorkDay = WorkDay(day = 2)
        val workDays = sortedSetOf(secondWorkDay, firstWorkDay)

        assertEquals(secondWorkDay, workDays[2])
    }

    @Test
    fun `Throws exception if queried day is not found`() {
        assertThrows<NoSuchElementException> {
            sortedSetOf(WorkDay(day = 3))[1]
        }
    }

}

