/*
* 513. Find Bottom Left Tree Value
Medium
3.1K
252
Companies
Given the root of a binary tree, return the leftmost value in the last row of the tree.
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

// https://leetcode.com/problems/find-bottom-left-tree-value/

class Solution513kt {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun findBottomLeftValue(root: TreeNode?): Int {
        return findLeftValueWithHeight(root).second
    }

    fun findLeftValueWithHeight(root: TreeNode?): Pair<Int, Int> {
        // TODO
        if (root == null) {
            return 0 to 0
        }
        val l = findLeftValueWithHeight(root.left)
        var r = findLeftValueWithHeight(root.right)
        if (l.first == 0 && r.first == 0) {
            return 1 to root.`val`
        }
        return if (l.first >= r.first) {
            l.first + 1 to l.second
        } else {
            r.first + 1 to r.second
        }
    }
}