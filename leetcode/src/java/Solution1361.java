/*1361. Validate Binary Tree Nodes
    Medium
    2K
    485
    Companies
    You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i]
    and rightChild[i],
    return true if and only if all the given nodes form exactly one valid binary tree.

    If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

    Note that the nodes have no values and that we only use the node numbers in this problem.

    https://leetcode.com/problems/validate-binary-tree-nodes/?envType=daily-question&envId=2023-12-13*/
public class Solution1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] ins = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] == i || rightChild[i] == i) {
                return false;
            }
            if (leftChild[i] >= 0) {
                ins[leftChild[i]]++;
            }
            if (rightChild[i] >= 0) {
                ins[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (ins[i] > 1) {
                return false;
            }
            if (ins[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = false;
        }
        if (visit(b, root, leftChild, rightChild)) {
            for (int i = 0; i < n; i++) {
                if (!b[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean visit(boolean[] b, int node, int[] leftChild, int[] rightChild) {
        if (node == -1) {
            return true;
        }
        if (b[node]) {
            return false;
        }
        b[node] = true;
        return visit(b, leftChild[node], leftChild, rightChild) &&
            visit(b, rightChild[node], leftChild, rightChild);

    }

    public static void main(String[] args) {
        Solution1361 s = new Solution1361();
        System.out.println(s.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
        System.out.println(s.validateBinaryTreeNodes(4, new int[]{1,0,3,-1}, new int[]{-1,-1,-1,-1}));

    }
}
