class Solution706kt {
    class Node(
        val key: Int,
        var value: Int,
        var next: Node? = null
    )

    private val HASH_KEY: Int = 10007

    val map: MutableList<Node?> = List(HASH_KEY) { null }.toMutableList()

    fun put(key: Int, value: Int) {
        val index = key % HASH_KEY
        if (map[index] == null) {
            map[index] = Node(key, value)
        } else {
            var node = map[index]
            while (node != null) {
                if (node.key == key) {
                    node.value = value
                    return
                }
                node = node.next
            }
            node = Node(key, value, map[index])
            map[index] = node
        }
    }

    fun get(key: Int): Int {
        val index = key % HASH_KEY
        var node = map[index]
        while (node != null && node.key != key) {
            node = node.next
        }
        return node?.value ?: -1
    }

    fun remove(key: Int) {
        val index = key % HASH_KEY
        var node: Node? = map[index] ?: return
        if (node != null && node.key == key) {
            map[index] = node.next
            return
        }
        while (node!!.next != null && node!!.next!!.key != key) {
            node = node.next
        }
        if (node!!.next != null) {
            node.next = node!!.next!!.next
        }
    }
}

fun main() {
    val myHashMap = Solution706kt()
    println(myHashMap.put(1, 1)) // The map is now [[1,1]]

    println(myHashMap.put(2, 2)) // The map is now [[1,1], [2,2]]

    println(myHashMap.get(1)) // return 1, The map is now [[1,1], [2,2]]

    myHashMap.get(3) // return -1 (i.e., not found), The map is now [[1,1], [2,2]]

    myHashMap.put(2, 1) // The map is now [[1,1], [2,1]] (i.e., update the existing value)

    myHashMap.get(2) // return 1, The map is now [[1,1], [2,1]]

    myHashMap.remove(2) // remove the mapping for 2, The map is now [[1,1]]

    myHashMap.get(2) // return -1 (i.e., not found), The map is now [[1,1]]
}