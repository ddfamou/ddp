class Solution1282kt {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        var map = mutableMapOf<Int, MutableList<Int>>()
        var result = mutableListOf<MutableList<Int>>()
        groupSizes.forEachIndexed { index, value ->
            if (map.contains(value)) {
                map[value]!!.add(index)
                if (map[value]!!.size == value) {
                    result.add(map[value]!!)
                    map.remove(value)
                }
            } else {
                if (value == 1) {
                    result.add(mutableListOf(index))
                } else {
                    map[value] = mutableListOf(index)
                }
            }
        }
        return result
    }
}

fun main() {
    println(Solution1282kt().groupThePeople(intArrayOf(3,3,3,3,3,1,3)))
}