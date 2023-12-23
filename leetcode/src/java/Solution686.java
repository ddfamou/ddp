public class Solution686 {
    public int repeatedStringMatch(String a, String b) {
        if (b.length() == 0) {
            return 0;
        }
        String s = "";
        int cnt = 0;
        while (s.length() < b.length()) {
            s += a;
            cnt++;
        }
        if (s.indexOf(b) == -1) {
            s += a;
            if (s.indexOf(b) == -1) {
                return -1;
            } else {
                return cnt + 1;
            }
        } else {
            return cnt;
        }
    }
}
