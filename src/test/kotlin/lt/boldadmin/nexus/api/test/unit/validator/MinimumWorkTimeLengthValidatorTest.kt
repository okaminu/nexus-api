package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.mockk
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.MinimumWorkTimeLengthValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MinimumWorkTimeLengthValidatorTest {

    @Test
    fun `Validation passes when all work days time is not shorter than 15 minutes`() {
        val workTime = Array(7) { TimeRange(0, 100) }

        assertTrue(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation passes when work days with length of 15 minutes are contained`() {
        val workTime = Array(7) { TimeRange(5, 20) }

        assertTrue(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when at least one work day time is shorter than 15 minutes`() {
        val workTime = Array(6) { TimeRange(0, 100) } + TimeRange(20, 30)

        assertFalse(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

}
