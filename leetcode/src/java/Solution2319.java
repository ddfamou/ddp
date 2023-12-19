public class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || i + j == n - 1) && grid[i][j] == 0) {
                    return false;
                }
                if ((i != j && i + j != n - 1 && grid[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution2319 s = new Solution2319();
        s.checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}});
    }
}
