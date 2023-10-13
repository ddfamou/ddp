/*1480. Running Sum of 1d Array
Easy
7.3K
327
Companies
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.



Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]


Constraints:

1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
* */

// https://leetcode.com/problems/running-sum-of-1d-array/
class Solution1480kt {
    fun runningSum(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = nums[0]
        for (i in 1 until nums.size) {
            result[i] = nums[i] + result[i-1]
        }
        return result
    }
}

fun main() {
    println(Solution1480kt().runningSum(intArrayOf(1, 1, 1, 1, 1)).toList())
    println(Solution1480kt().runningSum(intArrayOf(1, 2, 3, 4, 5)).toList())
}