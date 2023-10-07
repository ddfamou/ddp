// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
class Solution211kt() {
    data class Node(
        var word: Boolean = false,
        val children: MutableList<Node?> = List(26) { null }.toMutableList()
    )
    private val root = Node()

    fun addWord(word: String) {
        var n = root
        word.toCharArray().forEachIndexed { index, c ->
            if (n.children[c - 'a'] == null) {
                n.children[c - 'a'] = Node()
                n = n.children[c - 'a']!!
            } else {
                n = n.children[c - 'a']!!
            }
            if (index == word.length - 1) {
                n.word = true
            }
        }
    }

    fun search(word: String): Boolean {
        return search(word, 0, root)
    }

    fun search(word: String, index: Int, n: Node): Boolean {
        val c = word[index]
        if (c != '.') {
            val nn = n.children[c - 'a'] ?: return false
            return if (index + 1 == word.length) {
                nn.word
            } else {
                search(word, index+1, nn)
            }
        } else {
            var result = false
            if (index + 1 == word.length) {
                n.children.forEach {
                    if (it != null && it.word) {
                        result = true
                        return@forEach
                    }
                }
            } else {
                n.children.forEach {
                    if (it != null && search(word, index + 1, it)) {
                        result = true
                        return@forEach
                    }
                }
            }
            return result
        }



    }

}

/*
class Solution211kt() {
    private val dict = mutableSetOf<String>()

    fun addWord(word: String) {
        dict.add(word)
    }

    fun search(word: String): Boolean {
        val index = word.indexOf('.')
        if ( index == -1) {
            return dict.contains(word)
        }
        for (c in 'a'..'z') {
            if (search(word.replaceFirst('.',c))) {
                return true
            }
        }
        return false
    }

}
*/

fun main() {
    val wordDictionary = Solution211kt()
    wordDictionary.addWord("a");
    wordDictionary.addWord("ab");
    println(wordDictionary.search("a")) // return False
    println(wordDictionary.search("a.")) // return False
    println(wordDictionary.search(".ad")) // return False
    println(wordDictionary.search("b..")) // return False
    wordDictionary.search("bad"); // return True
    wordDictionary.search(".ad"); // return True
    wordDictionary.search("b.."); // return True
}