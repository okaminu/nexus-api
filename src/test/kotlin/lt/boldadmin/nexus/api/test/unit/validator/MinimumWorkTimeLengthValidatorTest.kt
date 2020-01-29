package lt.boldadmin.nexus.api.test.unit.validator

import io.mockk.*
import lt.boldadmin.nexus.api.type.valueobject.TimeRange
import lt.boldadmin.nexus.api.validator.MinimumWorkTimeLengthValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MinimumWorkTimeLengthValidatorTest {

    @Test
    fun `Validation passes when all day times are not shorter than 15 minutes`() {
        val workTime = List(7) { TimeRange(0, 100) }

        assertTrue(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation passes when day times with length of 15 minutes are contained`() {
        val workTime = List(7) { TimeRange(5, 20) }

        assertTrue(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation fails when at least one day time is shorter than 15 minutes`() {
        val workTime = List(6) { TimeRange(0, 100) } + TimeRange(20, 30)

        assertFalse(MinimumWorkTimeLengthValidator().isValid(workTime, mockk()))
    }

    @Test
    fun `Validation short-circuits on first failure`() {
        val workTimeSpy = spyk(TimeRange(20, 21))
        val workTime = listOf(TimeRange(20, 21)) + workTimeSpy + List(5) { TimeRange(20, 21) }

        MinimumWorkTimeLengthValidator().isValid(workTime, mockk())

        verify { workTimeSpy wasNot called }
    }

}
