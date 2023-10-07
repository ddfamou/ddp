/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
*/
class Solution383kt {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val cnt = List(26) { 0 }.toMutableList()
        magazine.forEach { c -> cnt[c - 'a']++ }
        var result = true
        ransomNote.toCharArray().forEach { c ->
            cnt[c - 'a']--
            if (cnt[c - 'a'] < 0) {
                result = false
                return@forEach
            }
        }
        return result
    }
}