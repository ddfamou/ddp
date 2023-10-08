import java.lang.Math.random

class Solution470kt {
    fun rand10(): Int {
        var v = rand7() + 7 * (rand7() - 1)
        return if (v > 40) {
            rand10()
        } else {
            v % 10 + 1
        }
    }
    fun rand7() = (random() * 7).toInt() + 1
}

fun main() {
    for (i in 1..100) {
        println(Solution470kt().rand10())
    }
}