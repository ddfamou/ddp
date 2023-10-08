class Solution440kt {
    fun findKthNumber(n: Int, k: Int): Int {
        var current = 1L
        var count = 1L
        while (count < k) {
            val diff = valuesBetween(n, current, current + 1)
            if (diff + count <= k) {
                count += diff
                current++
            } else {
                current *= 10
                count++
            }
        }
        return current.toInt()

    }

    fun valuesBetween(n: Int, c: Long, c1: Long): Long {
        var begin = c
        var end = c1
        var result = 0L
        while (begin <= n) {
            result += (n + 1L).coerceAtMost(end) - begin
            begin *= 10
            end *= 10
        }
        return result
    }
}

/*    fun next(n: Int, current: Long): Long {
        if (current * 10 > 0 && current * 10 <= n) {
            return current * 10
        }
        if (current + 1 > n) {
            return refine(current / 10 + 1)
        }
        return refine(current + 1)
    }

    fun refine(n: Long): Long = if (n % 10 == 0L) {
            refine(n/10)
        } else {
            n
        }
}*/

fun main() {
    println(Solution440kt().findKthNumber(10, 3)) // 2
    println(Solution440kt().findKthNumber(13, 2)) // 10
    println(Solution440kt().findKthNumber(681692778, 351251360)) // 416126219
    println(Solution440kt().findKthNumber(957747794, 424238336)) // 481814499

}

