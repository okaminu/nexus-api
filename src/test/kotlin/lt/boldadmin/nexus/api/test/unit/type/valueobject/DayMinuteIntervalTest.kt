package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.DayMinuteInterval
import lt.boldadmin.nexus.api.type.valueobject.MinuteInterval
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY

class DayMinuteIntervalTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same days minute intervals are compared`() {
            assertEquals(
                0,
                DayMinuteInterval(TUESDAY, MinuteInterval(10, 20)).compareTo(DayMinuteInterval(TUESDAY))
            )
        }

        @Test
        fun `Returns 1 when day is compared to the previous day`() {
            assertEquals(1, DayMinuteInterval(WEDNESDAY).compareTo(DayMinuteInterval(TUESDAY)))
        }

        @Test
        fun `Returns -1 when day is compared to the following day`() {
            assertEquals(-1, DayMinuteInterval(TUESDAY).compareTo(DayMinuteInterval(WEDNESDAY)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same days of week are compared`() {
            assertTrue(DayMinuteInterval(TUESDAY, MinuteInterval(10, 20)) == DayMinuteInterval(TUESDAY))
        }

        @Test
        fun `Returns false when different days are compared`() {
            assertFalse(DayMinuteInterval(TUESDAY) == DayMinuteInterval(WEDNESDAY))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(DayMinuteInterval().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = DayMinuteInterval(TUESDAY)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = DayMinuteInterval(TUESDAY)
            val secondWorkDay = DayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = DayMinuteInterval(TUESDAY)
            val secondWorkDay = DayMinuteInterval(TUESDAY)
            val thirdWorkDay = DayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = DayMinuteInterval(TUESDAY)
            val secondWorkDay = DayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(DayMinuteInterval(TUESDAY) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, DayMinuteInterval(TUESDAY, MinuteInterval(100, 200), false).hashCode())
        }

        @Test
        fun `Equal days have equal hash code`() {
            val firstWorkDay = DayMinuteInterval(TUESDAY)
            val secondWorkDay = DayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = DayMinuteInterval(TUESDAY)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}