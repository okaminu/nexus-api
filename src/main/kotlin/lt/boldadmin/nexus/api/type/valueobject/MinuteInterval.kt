package lt.boldadmin.nexus.api.type.valueobject

data class MinuteInterval(var start: Short = 0, var end: Short = 0) {

    companion object {
        const val MIN: Short = 0
        const val MAX: Short = 1440
    }

}
