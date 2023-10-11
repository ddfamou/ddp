/*516. Longest Palindromic Subsequence
Medium
9.1K
314
Companies
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".*/

// https://leetcode.com/problems/longest-palindromic-subsequence/
class Solution516kt {
    fun longestPalindromeSubseq(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }

        // substring(i, j) =
        // max(substring(i+1, j-1), substring(i
        val dp = Array(s.length) { IntArray(s.length) }
        for (i in s.indices) {
            dp[i][i] = 1
        }
        for (i in 0..s.length -2 ) {
            dp[i][i+1] = if (s[i] == s[i+1]) {
                2
            } else {
                1
            }
        }
        for (l in 2 until s.length) {
            for (i in 0 until s.length - l) {
                if (s[i] == s[i+l]) {
                    dp[i][i+l] = Math.max(dp[i+1][i+l-1] + 2, Math.max(dp[i][i+l-1], dp[i+1][i+l]))
                } else {
                    dp[i][i+l] = Math.max(dp[i][i+l-1], dp[i+1][i+l])
                }
            }
        }
        return dp[0][s.length - 1]
    }
}

fun main() {
    println(Solution516kt().longestPalindromeSubseq("bbbab"))
}