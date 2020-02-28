package lt.boldadmin.nexus.api.test.unit.type.valueobject.time

import lt.boldadmin.nexus.api.type.valueobject.time.DayMinuteInterval
import lt.boldadmin.nexus.api.type.valueobject.time.MinuteInterval
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.*

class DayMinuteIntervalTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same day minute intervals are compared`() {
            val tuesdayMorning = DayMinuteInterval(TUESDAY, MinuteInterval(9, 10), false)
            val tuesdayNight = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            val compareResult = tuesdayMorning.compareTo(tuesdayNight)

            assertEquals(0, compareResult)
        }

        @Test
        fun `Returns 1 when day minute interval is compared to the previous day's`() {
            val wednesday = DayMinuteInterval(WEDNESDAY, MinuteInterval(0, 0), false)
            val tuesday = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            val compareResult = wednesday.compareTo(tuesday)

            assertEquals(1, compareResult)
        }

        @Test
        fun `Returns -1 when day minute interval is compared to the following day's`() {
            val tuesday = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val wednesday = DayMinuteInterval(WEDNESDAY, MinuteInterval(0, 0), false)

            val compareResult = tuesday.compareTo(wednesday)

            assertEquals(-1, compareResult)
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Same day intervals are equal`() {
            val tuesdayMorning = DayMinuteInterval(TUESDAY, MinuteInterval(9, 10), false)
            val tuesdayNight = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(tuesdayMorning == tuesdayNight)
        }

        @Test
        fun `Different day intervals are not equal`() {
            val tuesday = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val wednesday = DayMinuteInterval(WEDNESDAY, MinuteInterval(0, 0), false)

            assertFalse(tuesday == wednesday)
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Different types are not equal`() {
            assertFalse(DayMinuteInterval(MONDAY, MinuteInterval(0, 0), false).equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val i = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(i == i)
        }

        @Test
        fun `Is symmetric`() {
            val first = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val second = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(first == second)
            assertTrue(second == first)
        }

        @Test
        fun `Is transitive`() {
            val first = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val second = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val third = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(first == second)
            assertTrue(first == third)
        }

        @Test
        fun `Is consistent`() {
            val first = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val second = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(first == second)
            assertTrue(first == second)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Equal day minute intervals have equal hash code`() {
            val first = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)
            val second = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(first == second)
            assertTrue(first.hashCode() == second.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val i = DayMinuteInterval(TUESDAY, MinuteInterval(0, 0), false)

            assertTrue(i.hashCode() == i.hashCode())
            assertTrue(i.hashCode() == i.hashCode())
        }
    }
}
