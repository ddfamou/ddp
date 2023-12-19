import java.util.Arrays;

public class Solution2370 {
    public int longestIdealString(String s, int k) {
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int mm = -1;
            for (int j = Math.max(0, c - k); j <= Math.min(c + k, 25); j++) {
                mm = Math.max(mm, m[j]);
            }
            m[c] = mm + 1;
        }
        return Arrays.stream(m).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution2370 s = new Solution2370();
        System.out.println(s.longestIdealString("pvjcci", 4));
    }
}
