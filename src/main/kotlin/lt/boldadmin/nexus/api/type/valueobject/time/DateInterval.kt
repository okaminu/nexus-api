package lt.boldadmin.nexus.api.type.valueobject.time

import java.time.LocalDate

data class DateInterval(val start: LocalDate, val end: LocalDate) {

    init {
        require(start <= end) { "Interval start date should follow before end date" }
    }

}
