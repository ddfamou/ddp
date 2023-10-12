class Solution563kt {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun findTilt(root: TreeNode?): Int {
        return findTiltSum(root).second
    }

    // result[0] sum of values
    // result[1] sum of tilt
    fun findTiltSum(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return 0 to 0
        }
        val left = findTiltSum(root.left)
        val right = findTiltSum(root.right)
        return left.first + right.first + root.`val` to left.second + right.second + Math.abs(left.first - right.first)
    }
}