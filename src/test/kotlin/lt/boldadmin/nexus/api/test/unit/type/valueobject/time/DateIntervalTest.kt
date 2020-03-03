package lt.boldadmin.nexus.api.test.unit.type.valueobject.time

import lt.boldadmin.nexus.api.type.valueobject.time.DateInterval
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate.of
import java.time.Month

class DateIntervalTest {

    @Test
    fun `Can start before end date`() {
        val dateRange = DateInterval(of(2019, Month.JANUARY, 12), of(2019, Month.JANUARY, 13))

        assertNotEquals(dateRange, null)
    }

    @Test
    fun `Can start and end on the same day`() {
        val dateRange = DateInterval(of(2019, Month.JANUARY, 12), of(2019, Month.JANUARY, 12))

        assertNotEquals(dateRange, null)
    }

    @Test
    fun `Cannot end before start`() {
        val ex = assertThrows<IllegalArgumentException> {
            DateInterval(of(2019, Month.JANUARY, 13), of(2019, Month.JANUARY, 12))
        }

        assertTrue(ex.message!!.isNotBlank())
    }

}
