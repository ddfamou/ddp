class Solution543kt {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return searchTree(root).second
    }

    fun searchTree(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return 0 to 0
        }
        val l = searchTree(root.left)
        val r = searchTree(root.right)
        return Math.max(l.first, r.first) + 1 to Math.max(Math.max(l.second, r.second), l.first + r.first)
    }
}