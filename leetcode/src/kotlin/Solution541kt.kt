

class Solution541kt {
    fun reverseStr(s: String, k: Int): String {
        val ss = mutableListOf<String>()
        for (i in s.indices step k) {
            ss.add(s.substring(i, Math.min(i + k, s.length)))
        }
        return ss.mapIndexed{ index, s ->
            if (index % 2 == 0) {
                s.reversed()
            } else {
                s
            }
        }.joinToString("")
    }

}

fun main() {
    println(Solution541kt().reverseStr("abcdefg", 3))
}