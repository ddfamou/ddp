/*494. Target Sum
Medium
10.2K
331
Companies
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1


Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000*/


// https://leetcode.com/problems/target-sum/
class Solution494kt {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var map = mutableMapOf<Int, Int>()
        if (nums[0] == 0) {
            map[0] = 2
        } else {
            map[nums[0]] = 1
            map[-nums[0]] = 1
        }
        for (i in 1 until nums.size) {
            var newMap = mutableMapOf<Int, Int>()
            map.forEach {
                if (newMap.containsKey(it.key + nums[i])) {
                    newMap[it.key + nums[i]] = newMap[it.key + nums[i]]!! + it.value
                } else {
                    newMap[it.key + nums[i]] = it.value
                }
                if (newMap.containsKey(it.key - nums[i])) {
                    newMap[it.key - nums[i]] = newMap[it.key - nums[i]]!! + it.value
                } else {
                    newMap[it.key - nums[i]] = it.value
                }
            }
            map = newMap
        }
        return map[target] ?:0
    }
}

fun main() {
    println(Solution494kt().findTargetSumWays(intArrayOf(1,1,1,1,1), 3))
    println(Solution494kt().findTargetSumWays(intArrayOf(0,0,0,0,0,0,0,0,1), 1))
}