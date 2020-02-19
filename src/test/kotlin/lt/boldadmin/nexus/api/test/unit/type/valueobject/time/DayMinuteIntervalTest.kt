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
            val first = createDayMinuteInterval(TUESDAY, MinuteInterval(10, 20))
            val second = createDayMinuteInterval(TUESDAY)

            val compareResult = first.compareTo(second)

            assertEquals(0, compareResult)
        }

        @Test
        fun `Returns 1 when day minute interval is compared to the previous day's`() {
            val first = createDayMinuteInterval(WEDNESDAY)
            val second = createDayMinuteInterval(TUESDAY)

            val compareResult = first.compareTo(second)

            assertEquals(1, compareResult)
        }

        @Test
        fun `Returns -1 when day minute interval is compared to the following day's`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(WEDNESDAY)

            val compareResult = first.compareTo(second)

            assertEquals(-1, compareResult)
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same days minute intervals are compared`() {
            val first = createDayMinuteInterval(TUESDAY, MinuteInterval(10, 20))
            val second = createDayMinuteInterval(TUESDAY)

            assertTrue(first == second)
        }

        @Test
        fun `Returns false when day minute intervals of different days are compared`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(WEDNESDAY)

            assertFalse(first == second)
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(createDayMinuteInterval().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val i = createDayMinuteInterval(TUESDAY)

            assertTrue(i == i)
        }

        @Test
        fun `Is symmetric`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(TUESDAY)

            assertTrue(first == second)
            assertTrue(second == first)
        }

        @Test
        fun `Is transitive`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(TUESDAY)
            val third = createDayMinuteInterval(TUESDAY)

            assertTrue(first == second)
            assertTrue(first == third)
        }

        @Test
        fun `Is consistent`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(TUESDAY)

            assertTrue(first == second)
            assertTrue(first == second)
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
        fun `Equal day minute intervals have equal hash code`() {
            val first = createDayMinuteInterval(TUESDAY)
            val second = createDayMinuteInterval(TUESDAY)

            assertTrue(first == second)
            assertTrue(first.hashCode() == second.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val i = createDayMinuteInterval(TUESDAY)

            assertTrue(i.hashCode() == i.hashCode())
            assertTrue(i.hashCode() == i.hashCode())
        }

    }

    private fun createDayMinuteInterval(
        dayOfWeek: DayOfWeek = MONDAY,
        interval: MinuteInterval = MinuteInterval(0, 0),
        enabled: Boolean = false
    ) = DayMinuteInterval(dayOfWeek, interval, enabled)

}