class Solution433kt {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        var set = mutableSetOf<String>(startGene)
        var invisible = bank.toMutableSet()
        var depth = 0
        while (set.isNotEmpty()) {
            var newSet = mutableSetOf<String>()
            set.forEach {c ->
                if (distance(c, endGene) == 0) {
                    return depth
                }
                invisible.forEach {
                    if (distance(c, it) == 1) {
                        newSet.add(it)
                    }
                }
                invisible.removeAll(newSet)
            }
            depth++
            set = newSet
        }
        return -1
    }

    fun distance(a: String, b: String): Int {
        var dis = 0
        for (i in a.indices) {
            if (a[i] != b[i]) {
                dis++
            }
        }
        return dis
    }
}

fun main () {
    println(Solution433kt().minMutation("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA"))) // 1
    println(Solution433kt().minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA","AACCGCTA","AAACGGTA"))) // 2
    println(Solution433kt().minMutation("AAAAAAAA", "CCCCCCCC", arrayOf("AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"))) // -1
}