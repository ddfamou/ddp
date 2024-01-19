public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int[] limits = new int[26];
        for (char c : chars.toCharArray()) {
            limits[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] wc = new int[26];
            boolean in = true;
            for (char c : word.toCharArray()) {
                wc[c - 'a']++;
                if (wc[c - 'a'] > limits[c - 'a']) {
                    in = false;
                    break;
                }
            }
            if (in) {
                res += word.length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1160 s = new Solution1160();
        System.out.println(s.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        System.out.println(s.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
