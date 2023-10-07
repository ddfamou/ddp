class Solution389kt {
    fun findTheDifference(s: String, t: String): Char {
        val cnt = List(26) { 0 }.toMutableList()
        var result = 'a'
        s.toCharArray().forEach { cnt[it - 'a'] ++ }
        s.toCharArray().forEach {
            cnt[it - 'a'] --
            if (cnt[it - 'a'] < 0) {
                result = it
                return@forEach
            }
        }
        return result
    }

}

fun main() {
    println(Solution389kt().findTheDifference("", "y"))
    println(Solution389kt().findTheDifference("abcd", "abcde"))
}