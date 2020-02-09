package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.Day
import lt.boldadmin.nexus.api.type.valueobject.MinuteRange
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY

class DayTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same days of week are compared`() {
            assertEquals(
                0,
                Day(minuteInterval = MinuteRange(10, 20), dayOfWeek = TUESDAY).compareTo(Day(dayOfWeek = TUESDAY))
            )
        }

        @Test
        fun `Returns 1 when day is compared to the previous day`() {
            assertEquals(1, Day(dayOfWeek = WEDNESDAY).compareTo(Day(dayOfWeek = TUESDAY)))
        }

        @Test
        fun `Returns -1 when day is compared to the following day`() {
            assertEquals(-1, Day(dayOfWeek = TUESDAY).compareTo(Day(dayOfWeek = WEDNESDAY)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same days of week are compared`() {
            assertTrue(Day(minuteInterval = MinuteRange(10, 20), dayOfWeek = TUESDAY) == Day(dayOfWeek = TUESDAY))
        }

        @Test
        fun `Returns false when different days are compared`() {
            assertFalse(Day(dayOfWeek = TUESDAY) == Day(dayOfWeek = WEDNESDAY))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(Day().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = Day(dayOfWeek = TUESDAY)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = Day(dayOfWeek = TUESDAY)
            val secondWorkDay = Day(dayOfWeek = TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = Day(dayOfWeek = TUESDAY)
            val secondWorkDay = Day(dayOfWeek = TUESDAY)
            val thirdWorkDay = Day(dayOfWeek = TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = Day(dayOfWeek = TUESDAY)
            val secondWorkDay = Day(dayOfWeek = TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(Day(dayOfWeek = TUESDAY) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, Day(MinuteRange(100, 200), false, TUESDAY).hashCode())
        }

        @Test
        fun `Equal days have equal hash code`() {
            val firstWorkDay = Day(dayOfWeek = TUESDAY)
            val secondWorkDay = Day(dayOfWeek = TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = Day(dayOfWeek = TUESDAY)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}