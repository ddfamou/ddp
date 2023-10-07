import java.util.StringJoiner

/*
* 1048. Longest String Chain
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.
Example 1:
Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

* Example 2:
Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].

* Example 3:
Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
*
* */
class Solution1048kt {
    fun longestStrChain(words: Array<String>): Int {
        if (words.size <= 1) {
            return words.size
        }
        val maxWordLength = words.maxBy { w -> w.length }.length
        var wordsByLength = mutableListOf<MutableList<String>>()
        for (i in 1..maxWordLength) {
            wordsByLength.add(mutableListOf())
        }
        val wordLengthMap = hashMapOf<String, Int>()
        words.forEach { w ->
            wordsByLength[w.length - 1].add(w)
            wordLengthMap[w] = 1
        }
        for (l in 1 until maxWordLength) {
            wordsByLength[l].forEach { w ->
                val pre = wordsByLength[l-1].filter { isPredecessor(it, w) }.maxByOrNull { wordLengthMap[it]!! }
                if (pre == null) {
                    wordLengthMap[w] = 1
                } else {
                    wordLengthMap[w] = wordLengthMap[pre]!! + 1
                }
            }
        }
        return wordLengthMap.maxBy { it.value }.value
    }

    fun isPredecessor(wordA: String, wordB: String): Boolean {
        if (wordA.length + 1 != wordB.length) {
            return false
        }
        // if wordA is predecessor of wordB, find Kth that wordA[K] != wordB[K]
        var i = 0
        while (i < wordA.length && wordA[i] == wordB[i]) {
            i++
        }
        while (i < wordA.length && wordA[i] == wordB[i+1]) {
            i++
        }
        return i == wordA.length
    }
}

fun main() {
    println(Solution1048kt().isPredecessor("a", "ba"))
    println(Solution1048kt().isPredecessor("ba", "bda"))
    println(Solution1048kt().isPredecessor("a", "ab"))
    println(Solution1048kt().isPredecessor("bda", "bdca"))
    println(Solution1048kt().isPredecessor("abcd", "dbqca"))
    println(Solution1048kt().isPredecessor("a", "ba"))
    println(Solution1048kt().longestStrChain(arrayOf("a","b","ba","bca","bda","bdca")))
}