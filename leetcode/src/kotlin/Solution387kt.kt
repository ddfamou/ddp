/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
Input: s = "leetcode"
Output: 0
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */
class Solution387kt {
    fun firstUniqChar(s: String): Int {
        val cnt: MutableList<Int> = List(26) { 0 }.toMutableList()
        val first: MutableList<Int> = List(26) { -1 }.toMutableList()
        s.toCharArray().forEachIndexed {index, c ->
            if (first[c-'a'] == -1) {
                first[c-'a'] = index
            } else {
                first[c-'a'] = s.length + 1
            }
        }
        return first.filter { f -> f != -1 && f != s.length + 1 }.minOrNull() ?: -1
    }
}

fun main() {
    println(Solution387kt().firstUniqChar("leetcode"))
    println(Solution387kt().firstUniqChar("loveleetcode"))
    println(Solution387kt().firstUniqChar("aabb"))

}