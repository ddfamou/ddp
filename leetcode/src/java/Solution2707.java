import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/*https://leetcode.com/problems/extra-characters-in-a-string/?envType=daily-question&envId=2023-12-18
2707. Extra Characters in a String
    Medium
    2K
    87
    Companies
    You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

    Return the minimum number of extra characters left over if you break up s optimally.



    Example 1:

    Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
    Output: 1
    Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

    Example 2:

    Input: s = "sayhelloworld", dictionary = ["hello","world"]
    Output: 3
    Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.


    Constraints:

    1 <= s.length <= 50
    1 <= dictionary.length <= 50
    1 <= dictionary[i].length <= 50
    dictionary[i] and s consists of only lowercase English letters
    dictionary contains distinct words*/
public class Solution2707 {

    class DicNode {
        boolean isWord;
        List<DicNode> dicNodes;
        DicNode() {
            this.isWord = false;
            dicNodes = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                dicNodes.add(null);
            }
        }

        public void isWord() {
            this.isWord = true;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        // todo
        DicNode dict = new DicNode();
        for (String word: dictionary) {
            addWord(word, dict);
        }
        int[] dp = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            DicNode node = dict;
            dp[i] = s.length() - i;
            for (int j = i; j < s.length(); j++) {
                dp[i] = Math.min(dp[i], dp[j] + j - i);
                if (node != null) {
                    node = node.dicNodes.get(s.charAt(j) - 'a');
                    if (node != null && node.isWord) {
                        dp[i] = Math.min(dp[i], dp[j + 1]);
                    }
                }
                if (dp[i] <= 0) {
                    break;
                }
            }
        }
        return dp[0];
    }

    private void addWord(String s, DicNode dictionary) {
        DicNode node = dictionary;
        for (char c : s.toCharArray()) {
            if (node.dicNodes.get(c - 'a') == null) {
                node.dicNodes.set(c - 'a', new DicNode());
            }
            node = node.dicNodes.get(c - 'a');
        }
        node.isWord();
    }

    public static void main(String[] args) {
        Solution2707 s = new Solution2707();
        System.out.println(s.minExtraChar("leetcode", new String[]{"leet", "code"}));
        System.out.println(s.minExtraChar("leetscode", new String[]{"leet", "code"}));
    }
}
