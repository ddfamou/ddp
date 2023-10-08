class Solution343 {
    fun integerBreak(n: Int): Int {
        if (n <= 3) {
            return when (n) {
                0 -> 0
                1 -> 1
                2 -> 1
                else -> 2
            }
        }
        val max = IntArray(n + 1)
        max[0] = 0
        max[1] = 1
        max[2] = 2
        max[3] = 3
        for (i in 4..n) {
            for (j in 2 .. i/2) {
                max[i] = Math.max(max[i], max[j] * max[i - j])
            }
        }
        println(max)
        return max[n]
    }
}

fun main() {
    Solution343().integerBreak(10)
}