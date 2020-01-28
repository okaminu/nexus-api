package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.type.valueobject.WorkDay
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WorkDayTest {

    @Nested
    inner class ComparisonTests {

        @Test
        fun `Returns 0 when same day work days are compared`() {
            assertEquals(0, WorkDay(time = TimeRange(10, 20), day = 2).compareTo(WorkDay(day = 2)))
        }

        @Test
        fun `Returns 1 when work day is compared to the previous day's`() {
            assertEquals(1, WorkDay(day = 3).compareTo(WorkDay(day = 2)))
        }

        @Test
        fun `Returns -1 when work day is compared to the following day's`() {
            assertEquals(-1, WorkDay(day = 2).compareTo(WorkDay(day = 3)))
        }

    }

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same day work days are compared`() {
            assertTrue(WorkDay(time = TimeRange(10, 20), day = 2) == WorkDay(day = 2))
        }

        @Test
        fun `Returns false when different work days are compared`() {
            assertFalse(WorkDay(day = 2) == WorkDay(day = 3))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(WorkDay().equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = WorkDay(day = 2)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = WorkDay(day = 2)
            val secondWorkDay = WorkDay(day = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = WorkDay(day = 2)
            val secondWorkDay = WorkDay(day = 2)
            val thirdWorkDay = WorkDay(day = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = WorkDay(day = 2)
            val secondWorkDay = WorkDay(day = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(WorkDay(day = 2) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, WorkDay(TimeRange(100, 200), false, 1).hashCode())
        }

        @Test
        fun `Equal work days have equal hash code`() {
            val firstWorkDay = WorkDay(day = 2)
            val secondWorkDay = WorkDay(day = 2)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = WorkDay(day = 2)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}