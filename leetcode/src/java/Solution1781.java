import java.util.HashMap;
import java.util.Map;

/*1781. Sum of Beauty of All Substrings
    Medium
    932
    155
    Companies
    The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

    For example, the beauty of "abaacc" is 3 - 1 = 2.
    Given a string s, return the sum of beauty of all of its substrings.



    Example 1:

    Input: s = "aabcb"
    Output: 5
    Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
    Example 2:

    Input: s = "aabcbaa"
    Output: 17


    Constraints:

    1 <= s.length <= 500
    s consists of only lowercase English letters.*/
public class Solution1781 {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int[] cnt = new int[26];
            cnt[s.charAt(i) - 'a']++;
            for (int j = i + 1; j < s.length(); j++ ) {
                cnt[s.charAt(j) - 'a']++;
                res += beauty(cnt);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution1781 s = new Solution1781();
        System.out.println(s.beautySum("aabcb"));
        System.out.println(s.beautySum("aabcbaa"));
        System.out.println(s.beautySum("aabcb"));
    }

    public int beauty(int[] cnt) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i : cnt) {
            if (i > 0) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
        }
        return max - min;
    }
}
