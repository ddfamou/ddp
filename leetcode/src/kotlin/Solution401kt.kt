class Solution401kt {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        var result = mutableListOf<String>()
        for (i in 0..turnedOn) {
            val hours = listOfNumber(i, 8, 4).filter { it < 12 }
            val minutes = listOfNumber(turnedOn, 32, 6).filter { it < 60 }.map {
                if (it < 10) {
                    "0$it"
                } else {
                    "$it"
                }
            }
            hours.forEach { h -> minutes.forEach {m -> result.add("$h:$m")} }
        }
        return result
    }

    fun binaryHour(turnedOn: Int) =
        when (turnedOn) {
            0 -> listOf("0")
            1 -> listOf("1", "2", "4", "8")
            2 -> listOf("3", "5", "9", "6", "10")
            else -> emptyList()
        }

    fun binaryMinutes(turnedOn: Int) =
        when (turnedOn) {
            0 -> listOf("00")
            1 -> listOf("01", "02", "04", "08", "16", "32")
            2 -> listOf("03", "05", "09", "06", "10", "16", "33", "34", "12", "20", "36", "24", "40", "48")
            3 -> listOf("07", "11", "19", "35", "14", "22", "38", "13")
            else -> emptyList()
        }

    fun listOfNumber(cnt: Int, max: Int, size: Int) : Set<Int> {
        if (cnt == 0) {
            return setOf(0)
        }
        if (cnt > size) {
            return emptySet()
        }
        if (cnt == size) {
            return setOf(max * 2 - 1)
        }
        return listOfNumber(cnt, max / 2, size - 1) +
            listOfNumber(cnt - 1, max / 2, size - 1).map { it + max }
    }

}

fun main() {
    println(Solution401kt().listOfNumber(0, 32, 6))
    println(Solution401kt().listOfNumber(1, 32, 6))
    println(Solution401kt().listOfNumber(2, 32, 6))
    println(Solution401kt().listOfNumber(3, 32, 6))
    println(Solution401kt().listOfNumber(4, 32, 6))
    println(Solution401kt().listOfNumber(5, 32, 6))
}