/*
* 1498. Number of Subsequences That Satisfy the Given Sum Condition
Medium
3.7K
327
Companies
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= target <= 106
* */
class Solution1498 {
    private val mod = 1000000007
    fun numSubseq(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = 0
        for (i in nums.indices) {
            if (nums[i] * 2 <= target) {
                result = if (nums[i] + nums[nums.size - 1] <= target) {
                    val v2 = quickPower((nums.size - 1 - i).toLong(), 2)
                    (result + v2) % mod
                } else {
                    val t = getMaximum(nums, target - nums[i], i, nums.size - 1)
                    val v2 = quickPower((t - i).toLong(), 2)
                    (result + v2) % mod
                }
            }
        }
        return result
    }

    fun getR(i: Int, j: Int): Int {
        if ( i == j)
            return 1
        var cnt = 1
        for (index in i until j) {
            cnt = cnt * 2 % mod
        }
        return cnt
    }

    fun getMaximum(nums: IntArray, value: Int, begin: Int, end: Int): Int {
        if (end - begin <= 1) {
            return begin
        }
        val mid = (begin + end) / 2
        return if (nums[mid] <= value) {
            getMaximum(nums, value, mid, end)
        } else {
            getMaximum(nums, value, begin, mid)
        }
    }

    private fun quickPower(power: Long, base: Long = 2): Int {
        var res = 1L
        var x = base;
        var y = power
        x %= mod
        if (x == 0L) return 0
        while (y > 0) {
            if (y % 2 == 1L) res = (res * x) % mod
            y /= 2
            x = (x * x) % mod
        }
        return (res % mod).toInt()
    }

}

fun main() {
    // println(Solution1498().getMaximum(listOf(3, 5, 6, 7).toIntArray(), 6, 0, 3))
    println(Solution1498().numSubseq(listOf(14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14).toIntArray(), 22))
}