package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.DateRange
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import java.time.Month

class DateRangeTest {

    @Test
    fun `Range start date should start before end date`() {
        val ex = assertThrows<IllegalArgumentException> {
            DateRange(
                LocalDate.of(2019, Month.FEBRUARY, 21),
                LocalDate.of(2019, Month.FEBRUARY, 19)
            )
        }

        assertTrue(ex.message!!.isNotBlank())
    }

}