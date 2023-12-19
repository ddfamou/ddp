import java.util.Arrays;

/*
518. Coin Change II
    Medium
    8.9K
    156
    Companies
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

    You may assume that you have an infinite number of each kind of coin.

    The answer is guaranteed to fit into a signed 32-bit integer.



    Example 1:

    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
    Example 2:

    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.
    Example 3:

    Input: amount = 10, coins = [10]
    Output: 1


    Constraints:

    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000
*/
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] cnt = new int[amount + 1];
        int[] c = Arrays.stream(coins).sorted().toArray();
        for (int i = 0; i < c.length; i++) {
            int nv = c[i];
            int[] t = new int[amount + 1];
            for (int j = 1; j <= amount; j++) {
                t[j] = cnt[j];
                if (j % nv == 0) {
                    t[j]++;
                }
                int k = j - nv;
                while (k >= 0) {
                    t[j] += cnt[k];
                    k = k - nv;
                }
            }
            cnt = t;
        }
        return cnt[amount];
    }

    public static void main(String[] args) {
        Solution518 s = new Solution518();
        //System.out.println(s.change(5, new int[]{1, 2, 3}));
        System.out.println(s.change(5, new int[]{1, 2, 5}));
    }
}


