class Solution1456kt {

    private val Vowels = setOf('a', 'e', 'i', 'o', 'u')
    fun maxVowels(s: String, k: Int): Int {
        var cnt = 0
        for (i in 0 until k) {
            cnt += valueOfChar(s[i])
        }
        var max = cnt
        var index = 0
        while (index + k < s.length) {
            cnt = cnt - valueOfChar(s[index]) + valueOfChar(s[index+k])
            max = cnt.coerceAtLeast(max)
            index++
        }
        return max
    }

    fun valueOfChar(c: Char): Int = if (c in Vowels) { 1 } else {0}
}

fun main() {
    println(Solution1456kt().maxVowels("abciiidef", 3))
    println(Solution1456kt().maxVowels("leetcode", 3))
}