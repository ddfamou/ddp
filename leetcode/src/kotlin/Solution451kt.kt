/*451. Sort Characters By Frequency
Medium
7.3K
242
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.*/

// https://leetcode.com/problems/sort-characters-by-frequency/
class Solution451kt {
    fun frequencySort(s: String): String {
        val count = IntArray(256)
        s.toCharArray().forEach { count[it - '0']++ }
        val list = mutableListOf<Pair<Int, Char>>()
        for (c in '0'..'z') {
            if (count[c - '0'] != 0) {
                list.add(count[c - '0'] to c)
            }
        }
        list.sortBy { -it.first }
        var result = ""
        list.forEach {
            result += it.second*it.first
        }
        return result
    }
    private operator fun Char.times(times: Int): String {
        val ar = CharArray(times) {this}
        return ar.concatToString()
    }
}


fun main() {
    println(Solution451kt().frequencySort("tree"))
    println(Solution451kt().frequencySort("aaaccc"))
    println(Solution451kt().frequencySort("Aabb"))
    println(Solution451kt().frequencySort("2a554442f544asfasssffffasss"))
}