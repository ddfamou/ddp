/*
* 1636. Sort Array by Increasing Frequency
Easy
2.7K
98
Companies
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]

* */
class Solution1636kt {
    fun frequencySort(nums: IntArray): IntArray {
        val hash = IntArray(201)
        nums.forEach { hash[it+100]++ }
        val list = mutableListOf<Pair<Int, Int>>()
        hash.forEachIndexed {index, v ->
            if (v > 0) {
                list.add(index - 100 to v)
            }
        }
        list.sortWith(PairComparator())
        val result = IntArray(nums.size)
        var index = 0
        list.forEach {
            for (i in 1..it.second) {
                result[index] = it.first
                index++
            }

        }
        return result
    }

    class PairComparator: Comparator<Pair<Int, Int>> {
        override
        fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
            if (o1.second == o2.second) {
                return o2.first - o1.first
            } else {
                return o1.second - o2.second
            }
        }
    }
}

fun main () {
    println(Solution1636kt().frequencySort(intArrayOf(-1,1,-6,4,5,-6,1,4,1)).toList())
}