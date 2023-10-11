/*482. License Key Formatting
Easy
1K
1.4K
Companies
You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.



Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.


Constraints:

1 <= s.length <= 105
s consists of English letters, digits, and dashes '-'.
1 <= k <= 104*/

//https://leetcode.com/problems/license-key-formatting/
class Solution482kt {
    fun licenseKeyFormatting(s: String, k: Int): String {
        var result = ""
        var tmp = ""
        s.toCharArray().reversed().filter { it != '-' }.map {
            if (it <= 'z' && it >= 'a') {
                (it + ('A' - 'a'))
            } else {
                it
            }
        }.forEach {
            tmp += it
            if (tmp.length == k) {
                result += '-'
                result += tmp
                tmp = ""
            }
        }
        if (tmp.length != 0) {
            result += '-'
            result += tmp
        }
        if (result.length <= 1) {
            return ""
        }
        return result.substring(1).reversed()
    }
}

fun main() {
    println(Solution482kt().licenseKeyFormatting("---", 3))
    println(Solution482kt().licenseKeyFormatting("2-5g-3-J", 2))
    println(Solution482kt().licenseKeyFormatting("5F3Z-2e-9-w", 4))
}