import java.util.Arrays;

public class Solution935 {
    public int knightDialer(int n) {
        long[] cnt = new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            long[] t = new long[10];
            t[0] = (cnt[4] + cnt[6]) % 1000000007;
            t[1] = (cnt[8] + cnt[6]) % 1000000007;
            t[2] = (cnt[7] + cnt[9]) % 1000000007;
            t[3] = (cnt[4] + cnt[8]) % 1000000007;
            t[4] = (cnt[3] + cnt[9] + cnt[0]) % 1000000007;
            t[6] = (cnt[1] + cnt[7] + cnt[0]) % 1000000007;
            t[7] = (cnt[2] + cnt[6]) % 1000000007;
            t[8] = (cnt[1] + cnt[3]) % 1000000007;
            t[9] = (cnt[2] + cnt[4]) % 1000000007;
            cnt = t;
        }
        return (int)(Arrays.stream(cnt).sum() % 1000000007);

    }
}
