class Solution367kt {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 0 || num == 1) {
            return true
        }
        var up = 1
        while (up * up < num && up * up > 0) {
            up = up * 2
        }
        if (up * up == num) {
            return true
        }
        return isPerfectSquare(num, 1, up)
    }

    private fun isPerfectSquare(num: Int, l: Int, u: Int): Boolean {
        val mid = (u - l) / 2 + l
        if (mid == u || mid == l) {
            return false
        }
        if (mid * mid == num) {
            return true
        }
        return if (mid * mid > num || mid * mid < 0) {

            isPerfectSquare(num, l, mid)
        } else {
            isPerfectSquare(num, mid, u)
        }
    }
}

fun main() {
    val s = Solution367()
    System.out.println(s.isPerfectSquare(2147395600))
    System.out.println(s.isPerfectSquare(808201))
    System.out.println(s.isPerfectSquare(Int.MAX_VALUE))
    System.out.println(s.isPerfectSquare(10000))
    System.out.println(s.isPerfectSquare(16))
}