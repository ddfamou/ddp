/*
414. Third Maximum Number
Easy
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.


Constraints:

1 <= nums.length <= 104
-2^31 <= nums[i] <= 2^31 - 1
*/

// https://leetcode.com/problems/third-maximum-number/
class Solution414kt {
    fun thirdMax(nums: IntArray): Int {
        var f = Long.MIN_VALUE
        var s = Long.MIN_VALUE
        var t = Long.MIN_VALUE
        nums.forEach {
            if (it > t && it.toLong() != f && it.toLong() != s) {
                if (it < s) {
                    t = it.toLong()
                } else {
                    t = s
                    if (it > f) {
                        s = f
                        f = it.toLong()
                    } else {
                        s = it.toLong()
                    }
                }
            }
        }
        return if (t == Long.MIN_VALUE) {
            f.toInt()
        } else {
            t.toInt()
        }
    }
}

fun main() {
    println(Solution414kt().thirdMax(intArrayOf(2, 2, 3, 1)))
    println(Solution414kt().thirdMax(intArrayOf(2, 3, 1)))
    println(Solution414kt().thirdMax(intArrayOf(4, 5, 2, 2, 3, 1)))
    println(Solution414kt().thirdMax(intArrayOf(1)))
    println(Solution414kt().thirdMax(intArrayOf(1, 2)))
}