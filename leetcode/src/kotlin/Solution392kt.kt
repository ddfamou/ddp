class Solution392kt {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
                j++
            } else {
                j++
            }
        }
        return (i >= s.length)
    }
}

fun main() {
    println(Solution392kt().isSubsequence("abc", "ahbgdc"))
    println(Solution392kt().isSubsequence("axc", "ahbgdc"))
}