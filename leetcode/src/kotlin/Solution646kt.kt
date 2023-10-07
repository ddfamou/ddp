class Solution646kt {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        // DP solution
        pairs.sortBy { p -> -p[0] }
        val depth = IntArray(pairs.size)
        for (i in pairs.indices) {
            for (j in i + 1 until pairs.size) {
                if (pairs[j][1] < pairs[i][0]) {
                    depth[j] = Math.max(depth[j], depth[i] + 1)
                }
            }
        }
        return depth.max() + 1
    }
}

fun main() {
    println(Solution646kt().findLongestChain(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3,4))))
    println(Solution646kt().findLongestChain(arrayOf(intArrayOf(1, 2), intArrayOf(7, 8), intArrayOf(3,4))))

}