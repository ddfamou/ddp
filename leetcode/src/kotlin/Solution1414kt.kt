/*
* 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
Medium
975
62
Companies
Given an integer k, return the minimum number of Fibonacci numbers whose sum is equal to k. The same Fibonacci number can be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 for n > 2.
It is guaranteed that for the given constraints we can always find such Fibonacci numbers that sum up to k.
Example 1:
Input: k = 7
Output: 2
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
For k = 7 we can use 2 + 5 = 7.
Example 2:

Input: k = 10
Output: 2
Explanation: For k = 10 we can use 2 + 8 = 10.
Example 3:

Input: k = 19
Output: 3
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.


Constraints:

1 <= k <= 109
* */

// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
class Solution1414kt {
    fun findMinFibonacciNumbers(k: Int): Int {
        if (k == 0) {
            return 0
        }
        if (k == 1 || k == 2) {
            return 1
        }
        var f = 1
        var s = 2
        while (k >= s) {
            val t = f + s
            f = s
            s = t
        }
        return findMinFibonacciNumbers(k - f) + 1
    }
}
// 1 1 2 3 5 8 13
fun main() {
    println(Solution1414kt().findMinFibonacciNumbers(7)) // 2 + 5
    println(Solution1414kt().findMinFibonacciNumbers(10)) // 2 + 8
    println(Solution1414kt().findMinFibonacciNumbers(5)) // 2 + 8
    println(Solution1414kt().findMinFibonacciNumbers(19)) // 1 + 3 + 13
    println(Solution1414kt().findMinFibonacciNumbers(50)) //
}