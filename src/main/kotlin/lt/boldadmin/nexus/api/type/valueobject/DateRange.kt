package lt.boldadmin.nexus.api.type.valueobject

import java.time.LocalDate

data class DateRange(val start: LocalDate, val end: LocalDate) {

    init {
        require(start <= end) { "Range start date should follow before end date" }
    }

}
