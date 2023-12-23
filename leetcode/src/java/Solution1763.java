import kotlin.Pair;

/*1763. Longest Nice Substring
    Easy
    1.3K
    834
    Companies
    A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

    Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.



    Example 1:

    Input: s = "YazaAay"
    Output: "aAa"
    Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
    "aAa" is the longest nice substring.
    Example 2:

    Input: s = "Bb"
    Output: "Bb"
    Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
    Example 3:

    Input: s = "c"
    Output: ""
    Explanation: There are no nice substrings.


    Constraints:

    1 <= s.length <= 100
    s consists of uppercase and lowercase English letters.
    https://leetcode.com/problems/longest-nice-substring/*/
public class Solution1763 {
    public String longestNiceSubstring(String s) {
        Pair<Integer, Integer> p = longestNiceSubString(s.toCharArray(), 0, s.length() - 1);
        return s.substring(p.getFirst(), p.getSecond() + 1);
    }

    public Pair<Integer, Integer> longestNiceSubString(char[] c, int start, int end) {
        if (end <= start) {
            return new Pair<>(start, start - 1);
        }
        int mid = findFirstBadChar(c, start, end);
        if (mid < 0) {
            return new Pair<>(start, end);
        } else {
            Pair<Integer, Integer> p1 = longestNiceSubString(c, start, mid - 1);
            Pair<Integer, Integer> p2 = longestNiceSubString(c, mid + 1, end);
            if (p1.getSecond() - p1.getFirst() > p2.getSecond() - p2.getFirst()) {
                return p1;
            } else {
                return p2;
            }
        }
    }

    public static void main(String[] args) {
        Solution1763 s = new Solution1763();
        System.out.println(s.longestNiceSubstring("xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL"));
        //System.out.println(s.longestNiceSubstring("Bb"));
        //System.out.println(s.longestNiceSubstring("c"));
    }

    private int findFirstBadChar(char[] c, int start, int end) {

        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < 26; i++) {
            upper[i] = -1;
            lower[i] = -1;
        }
        for (int i = start; i <= end; i++) {
            if (c[i] > 'Z') {
                lower[c[i] - 'a'] = i;
            } else {
                upper[c[i] - 'A'] = i;
            }
        }
        for (int i = 0; i < 26; i++ ) {
            if (upper[i] == -1 && lower[i] != -1 || upper[i] != -1 && lower[i] == -1) {
                return -upper[i] * lower[i];
            }
        }
        return -1;
    }

}
