/*
1582. Special Positions in a Binary Matrix
    Easy
    1K
    37
    Companies
    Given an m x n binary matrix mat, return the number of special positions in mat.

    A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

*/

public class Solution1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] mc = new int[m];
        int[] nc = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mc[i] += mat[i][j];
                nc[j] += mat[i][j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && mc[i] == 1 && nc[j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0,0},{0,0,1},{1,0,0}};
        Solution1582 s = new Solution1582();
        System.out.println(s.numSpecial(input));
    }
}
