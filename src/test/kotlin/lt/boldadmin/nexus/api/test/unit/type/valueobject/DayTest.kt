package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.Day
import lt.boldadmin.nexus.api.type.valueobject.MinuteRange
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DayTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same days of week are compared`() {
            assertEquals(
                0,
                Day(minuteRange = MinuteRange(10, 20), dayOfWeekIndex = 2).compareTo(Day(dayOfWeekIndex = 2))
            )
        }

        @Test
        fun `Returns 1 when day is compared to the previous day`() {
            assertEquals(1, Day(dayOfWeekIndex = 3).compareTo(Day(dayOfWeekIndex = 2)))
        }

        @Test
        fun `Returns -1 when day is compared to the following day`() {
            assertEquals(-1, Day(dayOfWeekIndex = 2).compareTo(Day(dayOfWeekIndex = 3)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same days of week are compared`() {
            assertTrue(Day(minuteRange = MinuteRange(10, 20), dayOfWeekIndex = 2) == Day(dayOfWeekIndex = 2))
        }

        @Test
        fun `Returns false when different days are compared`() {
            assertFalse(Day(dayOfWeekIndex = 2) == Day(dayOfWeekIndex = 3))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(Day().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = Day(dayOfWeekIndex = 2)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = Day(dayOfWeekIndex = 2)
            val secondWorkDay = Day(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = Day(dayOfWeekIndex = 2)
            val secondWorkDay = Day(dayOfWeekIndex = 2)
            val thirdWorkDay = Day(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = Day(dayOfWeekIndex = 2)
            val secondWorkDay = Day(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(Day(dayOfWeekIndex = 2) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, Day(MinuteRange(100, 200), false, 1).hashCode())
        }

        @Test
        fun `Equal days have equal hash code`() {
            val firstWorkDay = Day(dayOfWeekIndex = 2)
            val secondWorkDay = Day(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = Day(dayOfWeekIndex = 2)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}