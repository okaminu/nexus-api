package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.DayTime
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DayTimeTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same day time are compared`() {
            assertEquals(0, DayTime(time = TimeRange(10, 20), dayOfWeekIndex = 2).compareTo(DayTime(dayOfWeekIndex = 2)))
        }

        @Test
        fun `Returns 1 when day time is compared to the previous day's`() {
            assertEquals(1, DayTime(dayOfWeekIndex = 3).compareTo(DayTime(dayOfWeekIndex = 2)))
        }

        @Test
        fun `Returns -1 when day time is compared to the following day's`() {
            assertEquals(-1, DayTime(dayOfWeekIndex = 2).compareTo(DayTime(dayOfWeekIndex = 3)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same day time are compared`() {
            assertTrue(DayTime(time = TimeRange(10, 20), dayOfWeekIndex = 2) == DayTime(dayOfWeekIndex = 2))
        }

        @Test
        fun `Returns false when different day times are compared`() {
            assertFalse(DayTime(dayOfWeekIndex = 2) == DayTime(dayOfWeekIndex = 3))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(DayTime().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = DayTime(dayOfWeekIndex = 2)
            val secondWorkDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = DayTime(dayOfWeekIndex = 2)
            val secondWorkDay = DayTime(dayOfWeekIndex = 2)
            val thirdWorkDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = DayTime(dayOfWeekIndex = 2)
            val secondWorkDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(DayTime(dayOfWeekIndex = 2) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, DayTime(TimeRange(100, 200), false, 1).hashCode())
        }

        @Test
        fun `Equal day times have equal hash code`() {
            val firstWorkDay = DayTime(dayOfWeekIndex = 2)
            val secondWorkDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = DayTime(dayOfWeekIndex = 2)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}