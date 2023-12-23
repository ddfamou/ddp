public class Solution662 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int depth = getDepth(root);
        long[] min = new long[depth];
        long[] max = new long[depth];
        for (int i =0; i < depth; i++) {
            min[i] = Long.MAX_VALUE;
            max[i] = Long.MIN_VALUE;
        }
        update(root, 0, 0, min, max);
        long res = 0;
        for (int i = 0; i < depth; i++) {
            res = Math.max(res, max[i] - min[i] + 1);
        }
        return (int)res;
    }

    void update(TreeNode node, int d, long currentIndex, long[] min, long[] max) {
        if (node == null) {
            return;
        }
        min[d] = Math.min(min[d], currentIndex);
        max[d] = Math.max(max[d], currentIndex);
        update(node.left, d + 1, currentIndex * 2, min, max);
        update(node.right, d + 1, currentIndex * 2 + 1, min, max);
        return;
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(node.left), getDepth(node.right));
        }
    }
}
