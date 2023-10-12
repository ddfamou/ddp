/*
* 629. K Inverse Pairs Array
Hard
2K
220
Companies
For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].

Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.



Example 1:

Input: n = 3, k = 0
Output: 1
Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.
Example 2:

Input: n = 3, k = 1
Output: 2
Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.

* Constraints:

1 <= n <= 1000
0 <= k <= 1000

* */

// https://leetcode.com/problems/k-inverse-pairs-array/
class Solution629kt {
    fun kInversePairs(n: Int, k: Int): Int {
        // n = 1 k = 0 return 0
        // dp(n, k) = dp(n-1,k) + dp(n-1, k-1) + ... dp(n-k, 0)

        val dp = Array(n + 1) {LongArray(k + 1)}
        dp[1][0] = 1
        for (i in 2..n) {
            for (j in 0..k) {
                for (ii in Math.max(0, j - i + 1)..j) {
                    dp[i][j] += dp[i-1][ii]
                }
                if (dp[i][j] > Int.MAX_VALUE) {
                    dp[i][j] %= 1000000007L
                }
            }
        }
        println(dp[n].toList())
        return (dp[n][k] % 1000000007L).toInt()
    }
}

fun main() {
    println(Solution629kt().kInversePairs(2, 2))
    println(Solution629kt().kInversePairs(1000, 1000))
    // 633612464
    // 663677020
}