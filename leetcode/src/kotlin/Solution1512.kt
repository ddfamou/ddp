class Solution1512 {
    fun numIdenticalPairs(nums: IntArray): Int {
        val hashed = IntArray(101)
        nums.forEach { it -> hashed[it]++ }
        var result = 0
        hashed.forEach { it -> result += it * (it - 1) / 2 }
        return result
    }
}