/*
* 1095. Find in Mountain Array
Hard
2.5K
97
Companies
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
* */
class Solution1095kt {
    class MountainArray(
        var list: IntArray
    ) {
        var count = 0
        var map = mutableMapOf<Int, Int>()
        fun get(index: Int): Int  {
            count ++
            if (map.containsKey(index)) {
                map[index] = map[index]!!+1
            } else {
                map[index] = 1
            }
            return list[index]
        }
        fun length(): Int = list.size


    }

    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val result = findInMountainArray(target, mountainArr, 0, mountainArr.length() - 1)
        println(mountainArr.count)
        println(mountainArr.map.filter { it ->
            it.value > 1
        })
        return result
    }

    fun findInMountainArray(target: Int, mountainArr: MountainArray, start: Int, end: Int): Int {
        if (end - start <= 1) {
            return if (mountainArr.get(start) == target) {
                start
            } else if (mountainArr.get(end) == target) {
                end
            } else {
                -1
            }
        }
        val m = (start + end) / 2
        val mv = mountainArr.get(m)
        val mmv = mountainArr.get(m-1)
        val left: Int
        var right: Int
        if (mmv < mv) {
            if (mmv == target) {
                left = m - 1
            } else if (mv == target) {
                left = m
            } else if (mmv < target){
                left = -1
            } else {
                left = findInAcsArray(target, mountainArr, start, m - 2)
            }
            right = findInMountainArray(target, mountainArr, m, end)
        } else {
            left = findInMountainArray(target, mountainArr, start, m - 1)

            right = if (mmv == target) {
                m - 1
            } else if (mv == target){
                m
            } else if (mv < target) {
                -1
            } else {
                findInDescArray(target, mountainArr, m + 1, end)
            }
        }
        return if (left != -1) {
           left
        } else {
            right
        }
    }

    fun findInAcsArray(target: Int, a: MountainArray, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }
        if (end - start <= 1) {
            return if (target == a.get(start)) {
                start
            } else if (target == a.get(end)) {
                end
            } else {
                -1
            }
        }
        val m = (start + end) / 2
        val mv = a.get(m)
        return if (mv == target) {
            m
        } else if (mv > target) {
            findInAcsArray(target, a, start, m - 1)
        } else {
            findInAcsArray(target, a, m + 1, end)
        }
    }

    fun findInDescArray(target: Int, a: MountainArray, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }
        if (end - start <= 1) {
            return if (target == a.get(start)) {
                start
            } else if (target == a.get(end)) {
                end
            } else {
                -1
            }
        }
        val m = (start + end) / 2
        val mv = a.get(m)
        return if (mv == target) {
            m
        } else if (mv < target) {
            findInDescArray(target, a, start, m - 1)
        } else {
            findInDescArray(target, a, m + 1, end)
        }
    }

}

fun main () {
    // Solution1095kt().findInMountainArray(2, Solution1095kt.MountainArray(intArrayOf(1,2,3,4,5,3,1)))
    // Solution1095kt().findInMountainArray(2, Solution1095kt.MountainArray(intArrayOf(1,2,3,4,5,3,1)))
    val list = mutableListOf<Int>()
    var i = 1
    while (i < 450001) {
        list.add(i)
        i +=100
    }
    i = 450001
    while (i>225051) {
        i -= 50
        list.add(i)
    }
    println(Solution1095kt().findInMountainArray(0, Solution1095kt.MountainArray(intArrayOf(1, 5, 2))))
    println(Solution1095kt().findInMountainArray(2, Solution1095kt.MountainArray(intArrayOf(3, 5, 3, 2, 0))))
    println(Solution1095kt().findInMountainArray(405001, Solution1095kt.MountainArray(list.toIntArray())))
}