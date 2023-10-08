import java.util.EnumSet.range

class Solution496kt {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val largerIndex = IntArray(nums2.size)
        var i = nums2.size - 1
        largerIndex[i] = -1
        while (i > 0) {
            i--
            if (nums2[i] < nums2[i+1]) {
                largerIndex[i] = i + 1
            } else {
                var index = largerIndex[i + 1]
                while (index != -1 && nums2[index] < nums2[i]) {
                    index = largerIndex[index]
                }
                largerIndex[i] = index
            }
        }
        var map = mutableMapOf<Int, Int>()
        nums2.forEachIndexed { index, value ->
            if (largerIndex[index] == -1) {
                map.put(value, -1)
            } else {
                map.put(value, nums2[largerIndex[index]])
            }

        }
        return nums1.map { it -> map[it]!! }.toIntArray()
    }
}

fun main() {
    println(Solution496kt().nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).toList())
}