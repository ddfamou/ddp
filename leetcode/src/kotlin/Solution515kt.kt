/*515. Find Largest Value in Each Tree Row
Medium
2.8K
97
Companies
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]


Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1*/

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
class Solution515kt {
    class TreeNode (
        var value: Int,
        var left: TreeNode?,
        var right: TreeNode?
        )

    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList();
        }
        val l = largestValues(root.left)
        val r = largestValues(root.right)
        var result = IntArray(Math.max(l.size, r.size)) + 1
        result[0] = root.value
        for (i in 0 until result.size - 1) {
            val lv = if (i < l.size) l[i] else Int.MIN_VALUE
            val rv = if (i < r.size) r[i] else Int.MIN_VALUE
            result[i+1] = Math.max(lv, rv)
        }
        return result.toList()
    }
}