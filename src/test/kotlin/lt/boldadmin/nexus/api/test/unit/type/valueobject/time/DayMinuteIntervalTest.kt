package lt.boldadmin.nexus.api.test.unit.type.valueobject.time

import lt.boldadmin.nexus.api.type.valueobject.time.DayMinuteInterval
import lt.boldadmin.nexus.api.type.valueobject.time.MinuteInterval
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.DayOfWeek.*

class DayMinuteIntervalTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same day minute intervals are compared`() {
            assertEquals(
                0,
                createDayMinuteInterval(TUESDAY, MinuteInterval(10, 20)).compareTo(createDayMinuteInterval(TUESDAY))
            )
        }

        @Test
        fun `Returns 1 when interval is compared to the previous day's`() {
            assertEquals(1, createDayMinuteInterval(WEDNESDAY).compareTo(createDayMinuteInterval(TUESDAY)))
        }

        @Test
        fun `Returns -1 when interval is compared to the following day's`() {
            assertEquals(-1, createDayMinuteInterval(TUESDAY).compareTo(createDayMinuteInterval(WEDNESDAY)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same days minute intervals are compared`() {
            assertTrue(createDayMinuteInterval(TUESDAY, MinuteInterval(10, 20)) == createDayMinuteInterval(TUESDAY))
        }

        @Test
        fun `Returns false when intervals of different days are compared`() {
            assertFalse(createDayMinuteInterval(TUESDAY) == createDayMinuteInterval(WEDNESDAY))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(createDayMinuteInterval().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = createDayMinuteInterval(TUESDAY)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = createDayMinuteInterval(TUESDAY)
            val secondWorkDay = createDayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = createDayMinuteInterval(TUESDAY)
            val secondWorkDay = createDayMinuteInterval(TUESDAY)
            val thirdWorkDay = createDayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = createDayMinuteInterval(TUESDAY)
            val secondWorkDay = createDayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(createDayMinuteInterval(TUESDAY) == null)
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
            val firstWorkDay = createDayMinuteInterval(TUESDAY)
            val secondWorkDay = createDayMinuteInterval(TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = createDayMinuteInterval(TUESDAY)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

    private fun createDayMinuteInterval(
        dayOfWeek: DayOfWeek = MONDAY,
        interval: MinuteInterval = MinuteInterval(0, 0),
        enabled: Boolean = false
    ) = DayMinuteInterval(dayOfWeek, interval, enabled)

}