/*
329. Longest Increasing Path in a Matrix
Hard
8.6K
127
Companies
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
*/


class Solution329kt {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty()) {
            return 0
        }
        val row = matrix.size
        val column = matrix[0].size

        var current = mutableSetOf<Pair<Int, Int>>()
        val longest = Array(matrix.size) {IntArray(matrix[0].size)}
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                current.add(Pair(i, j))
                longest[i][j] = 1
            }
        }
        while (current.isNotEmpty()) {
            var updated = mutableSetOf<Pair<Int, Int>>()
            current.forEach {
                if ((it.first - 1 >= 0) && (matrix[it.first][it.second] < matrix[it.first - 1][it.second]) && (longest[it.first][it.second] + 1 > longest[it.first - 1][it.second])) {
                    longest[it.first - 1][it.second] = longest[it.first][it.second] + 1
                    updated.add(Pair(it.first - 1, it.second))
                }
                if (it.first + 1 < row && matrix[it.first][it.second] < matrix[it.first + 1][it.second] && longest[it.first][it.second] + 1 > longest[it.first + 1][it.second]) {
                    longest[it.first + 1][it.second] = longest[it.first][it.second] + 1
                    updated.add(Pair(it.first + 1, it.second))
                }
                if ((it.second - 1 >= 0) && (matrix[it.first][it.second] < matrix[it.first][it.second - 1]) && (longest[it.first][it.second] + 1 > longest[it.first][it.second - 1])) {
                    longest[it.first][it.second - 1] = longest[it.first][it.second] + 1
                    updated.add(Pair(it.first, it.second - 1))
                }
                if ((it.second + 1 < column) && (matrix[it.first][it.second] < matrix[it.first][it.second + 1]) && (longest[it.first][it.second] + 1 > longest[it.first][it.second + 1])) {
                    longest[it.first][it.second + 1] = longest[it.first][it.second] + 1
                    updated.add(Pair(it.first, it.second + 1))
                }
            }
            current = updated
        }
        return longest.maxOf { it -> it.max() }
    }
}

fun main() {
    println(Solution329kt().longestIncreasingPath(arrayOf(intArrayOf(9, 9, 4), intArrayOf(6, 6, 8), intArrayOf(2, 2, 1))))
}