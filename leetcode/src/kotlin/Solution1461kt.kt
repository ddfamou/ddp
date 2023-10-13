/*
*
* 1461. Check If a String Contains All Binary Codes of Size K
Medium
2.2K
92
Companies
Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.



Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
Example 3:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.


Constraints:

1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20
* */
class Solution1461kt {
    fun hasAllCodes(s: String?, k: Int): Boolean {
        if (s == null) {
            return false
        }
        var max = 1L
        for (i in 1..k) {
            max *= 2
        }
        if (s.length - k + 1 < max) {
            return false
        }
        val checked = BooleanArray(max.toInt())
        var value = 0
        for (i in 0 until k) {
            value = value * 2 + (s[i] - '0')
        }
        checked[value] = true
        for (i in k until s.length) {
            value = value * 2 + (s[i] - '0')
            if (value >= max) {
                value -= max.toInt()
            }
            checked[value] = true
        }
        checked.forEach { b -> if (!b) return false }
        return true
    }
}

fun main() {
    println(Solution1461kt().hasAllCodes("00110110", 2))
    println(Solution1461kt().hasAllCodes("0110", 1))
    println(Solution1461kt().hasAllCodes("0110", 2))
    println(Solution1461kt().hasAllCodes("000011010111011001001111111001000100100100010100101100001101101101110001100100101111100111001001111001001010111010010101101001001110011100110101001001001000000110101001010011101100110110100010000", 7))
}