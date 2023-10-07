/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

// class Solution:GuessGame() {
//     override fun guessNumber(n:Int):Int {
//
//     }
//
//     fun guessInRange(a:Int, b:Int)
// }
class Solution374kt(private var c: Int) {
    fun guessNumber(n: Int): Int {
        if (guess(1) == 0){
            return 1
        }
        if (guess(n) == 0) {
            return n
        }
        return guessInRange(1, n)
    }

    private fun guessInRange(a: Int, b: Int): Int {
        val mid = (b - a) / 2 + a
        return when (guess(mid)) {
            0 -> mid
            1 -> guessInRange(mid, b)
            else -> guessInRange(a, mid)
        }

    }
    fun guess(num: Int) = if (num > c) {
        -1
    } else if (num == c) {
        0
    } else {
        1
    }
}

fun main() {
    val s1 = Solution374kt(2)
    println(s1.guessNumber(2))
}