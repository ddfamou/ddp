/*https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/?envType=daily-question&envId=2023-12-01
1662. Check If Two String Arrays are Equivalent
    Easy
    2.8K
    198
    Companies
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

    A string is represented by an array if the array elements concatenated in order forms the string.



    Example 1:

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true
    Explanation:
    word1 represents string "ab" + "c" -> "abc"
    word2 represents string "a" + "bc" -> "abc"
    The strings are the same, so return true.
    Example 2:

    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false
    Example 3:

    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true


    Constraints:

    1 <= word1.length, word2.length <= 103
    1 <= word1[i].length, word2[i].length <= 103
    1 <= sum(word1[i].length), sum(word2[i].length) <= 103
    word1[i] and word2[i] consist of lowercase letters.*/
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int wi1 = 0, wi2 = 0;
        int ci1 = 0, ci2 = 0;
        while (wi1 < word1.length && wi2 < word2.length &&
            word1[wi1].charAt(ci1) == word2[wi2].charAt(ci2)) {
            ci1++;
            ci2++;
            if (ci1 >= word1[wi1].length()) {
                ci1 = 0;
                wi1++;
            }
            if (ci2 >= word2[wi2].length()) {
                ci2 = 0;
                wi2++;
            }
        }
        return wi1 == word1.length && wi2 == word2.length;
    }

    public static void main(String[] args) {
        Solution1662 s = new Solution1662();
        System.out.println(s.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(s.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(s.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }
}
