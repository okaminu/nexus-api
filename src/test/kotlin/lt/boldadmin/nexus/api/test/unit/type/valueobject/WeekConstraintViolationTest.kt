package lt.boldadmin.nexus.api.test.unit.type.valueobject

import lt.boldadmin.nexus.api.type.valueobject.WeekConstraintViolation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY

class WeekConstraintViolationTest {

    @Nested
    inner class EqualityTests {

        @Test
        fun `Returns true when same week constraint violations are compared`() {
            assertTrue(WeekConstraintViolation("message", TUESDAY) == WeekConstraintViolation("otherMessage", TUESDAY))
        }

        @Test
        fun `Returns false when different week constraint violations are compared`() {
            assertFalse(WeekConstraintViolation("message", TUESDAY) == WeekConstraintViolation("message", WEDNESDAY))
        }

        @Test
        @Suppress("ReplaceCallWithBinaryOperator")
        fun `Returns false when comparing with other types`() {
            assertFalse(WeekConstraintViolation("message", TUESDAY).equals(Pair("", "")))
        }

        @Test
        fun `Is reflexive`() {
            val workDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(workDay == workDay)
        }

        @Test
        fun `Is symmetric`() {
            val firstWorkDay = WeekConstraintViolation("message", TUESDAY)
            val secondWorkDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(secondWorkDay == firstWorkDay)
        }

        @Test
        fun `Is transitive`() {
            val firstWorkDay = WeekConstraintViolation("message", TUESDAY)
            val secondWorkDay = WeekConstraintViolation("message", TUESDAY)
            val thirdWorkDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == thirdWorkDay)
        }

        @Test
        fun `Is consistent`() {
            val firstWorkDay = WeekConstraintViolation("message", TUESDAY)
            val secondWorkDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay == secondWorkDay)
        }

        @Test
        @Suppress("SENSELESS_COMPARISON")
        fun `Never equal to null`() {
            assertFalse(WeekConstraintViolation("message", TUESDAY) == null)
        }

    }

    @Nested
    inner class HashCodeTests {

        @Test
        fun `Generates hash code`() {
            assertEquals(1, WeekConstraintViolation("message", TUESDAY).hashCode())
        }

        @Test
        fun `Equal week constraint violations have equal hash code`() {
            val firstWorkDay = WeekConstraintViolation("message", TUESDAY)
            val secondWorkDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(firstWorkDay == secondWorkDay)
            assertTrue(firstWorkDay.hashCode() == secondWorkDay.hashCode())
        }

        @Test
        fun `Is consistent`() {
            val workDay = WeekConstraintViolation("message", TUESDAY)

            assertTrue(workDay.hashCode() == workDay.hashCode())
            assertTrue(workDay.hashCode() == workDay.hashCode())
        }

    }

}