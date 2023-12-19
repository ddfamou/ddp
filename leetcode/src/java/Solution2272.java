import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.Pair;

/*2272. Substring With Largest Variance
    Hard
    1.8K
    204
    Companies
    The variance of a string is defined as the largest difference between the number of occurrences
    of any 2 characters present in the string. Note the two characters may or may not be the same.

    Given a string s consisting of lowercase English letters only,
    return the largest variance possible among all substrings of s.
    A substring is a contiguous sequence of characters within a string.
    Example 1:

    Input: s = "aababbb"
    Output: 3
    Explanation:
    All possible variances along with their respective substrings are listed below:
    - Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
    - Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
    - Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
    - Variance 3 for substring "babbb".
    Since the largest possible variance is 3, we return it.
    Example 2:

    Input: s = "abcde"
    Output: 0
    Explanation:
    No letter occurs more than once in s, so the variance of every substring is 0.*/
public class Solution2272 {
    public int largestVariance(String s) {
        int res = 0;
        Set<Character> cSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            cSet.add(c);
        }
        for (char i : cSet) {
            for (char j : cSet) {
                if (i == j) {
                    continue;
                }
                int ci = 0;
                int cj = 0;
                for (char c : s.toCharArray()) {
                    if (c == j) {
                        cj++;
                        if (cj > ci) {
                            ci = 0;
                            cj = 0;
                        }
                    } else if (c == i) {
                        ci++;
                        if (ci > 0 && cj > 0) {
                            res = Math.max(ci - cj, res);
                        }
                    }
                }
                ci = 0;
                cj = 0;
                for (int k = s.length() - 1; k >= 0; k--) {
                    char c = s.charAt(k);
                    if (c == j) {
                        cj++;
                        if (cj > ci) {
                            ci = 0;
                            cj = 0;
                        }
                    } else if (c == i) {
                        ci++;
                        if (ci > 0 && cj > 0) {
                            res = Math.max(ci - cj, res);
                        }
                    }
                }
            }
        }
        return res;
    }

    public int findDiff(int[] cnt) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                max = Math.max(max, cnt[i]);
                min = Math.min(min, cnt[i]);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {

        Solution2272 s = new Solution2272();
        System.out.println(s.largestVariance("aababbbaababbb"));
        System.out.println(s.largestVariance("abcdef"));
    }
}
