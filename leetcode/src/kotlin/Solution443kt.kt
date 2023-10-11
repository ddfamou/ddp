class Solution443kt {
    fun compress(chars: CharArray): Int {
        if (chars.size <= 1) {
            return chars.size
        }
        var c = chars[0]
        var cnt = 1
        var ca = ""
        for (i in 1 until chars.size) {
            if (chars[i] == c) {
                cnt++
            } else {
                ca += c
                if (cnt != 1) {
                    ca += cnt.toString()
                }
                cnt = 1
                c = chars[i]
            }
        }

        ca += c
        if (cnt != 1) {
            ca += cnt.toString()
        }
        ca.toCharArray().forEachIndexed {
                it, c ->
            chars[it] = c
        }

        return ca.length
    }
}

fun main() {
    println(Solution443kt().compress(charArrayOf('a','a','b','b','c','c','c')))
    println(Solution443kt().compress(charArrayOf('a')))
    println(Solution443kt().compress("abbbbbbbbbbbb".toCharArray()))
}