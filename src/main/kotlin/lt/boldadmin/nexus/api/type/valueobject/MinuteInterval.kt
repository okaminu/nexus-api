package lt.boldadmin.nexus.api.type.valueobject

data class MinuteInterval(val start: Short, val end: Short) {

    companion object {
        const val MIN: Short = 0
        const val MAX: Short = 1440
    }

}
