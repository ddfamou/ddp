/*
* 146. LRU Cache
Medium
19.5K
880
Companies
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
* https://leetcode.com/problems/lru-cache/description/
* */

class Solution146kt(val capacity: Int) {
    var currentSize = 0
    val map = mutableMapOf<Int, LinkedNode>()
    var head: LinkedNode? = null
    var tail: LinkedNode? = null

    class LinkedNode(var key: Int, var value: Int) {
        var preNode: LinkedNode? = null
        var nextNode: LinkedNode? = null
    }
    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val node = map[key]!!
            if (node != head) {
                moveToHead(node)
            }
            node.value
        } else {
             -1
        }
    }

    private fun moveToHead(node: LinkedNode) {
        if (node == head) {
            return
        }
        if (node == tail) {
            tail = node.preNode
            tail!!.nextNode = null
            node.preNode = null
            node.nextNode = head
            head!!.preNode = node
            head = node
            return
        }
        val pre = node.preNode
        val ne = node.nextNode
        pre!!.nextNode = ne
        ne!!.preNode = pre
        node.preNode = null
        node.nextNode = head
        head!!.preNode = node
        head = node
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key]!!.value = value
            moveToHead(map[key]!!)
        } else {
            val newNode = LinkedNode(key, value)
            map[key] = newNode
            if (head == null) {
                head = newNode
                tail = newNode
            } else {
                head!!.preNode = newNode
                newNode.nextNode = head
                head = newNode
            }
            if (currentSize < capacity) {
                currentSize++
            } else {
                map.remove(tail!!.key)
                tail = tail!!.preNode
                tail!!.nextNode = null
            }
        }
    }
}