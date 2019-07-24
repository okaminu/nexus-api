package lt.boldadmin.nexus.api.type.valueobject

import java.time.LocalDate

data class DateRange(val start: LocalDate = LocalDate.EPOCH, val end: LocalDate = LocalDate.now()) {

    init {
        if (this.start.isAfter(this.end))
            throw IllegalArgumentException("Range start date should follow before end date")
    }

}
