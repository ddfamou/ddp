/*
https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/?envType=daily-question&envId=2023-12-26
1155. Number of Dice Rolls With Target Sum
    Medium
    4.2K
    133
    Companies
    You have n dice, and each die has k faces numbered from 1 to k.

    Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.



    Example 1:

    Input: n = 1, k = 6, target = 3
    Output: 1
    Explanation: You throw one die with 6 faces.
    There is only one way to get a sum of 3.
    Example 2:

    Input: n = 2, k = 6, target = 7
    Output: 6
    Explanation: You throw two dice, each with 6 faces.
    There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
    Example 3:

    Input: n = 30, k = 30, target = 500
    Output: 222616187
    Explanation: The answer must be returned modulo 109 + 7.


    Constraints:

    1 <= n, k <= 30
*/

public class Solution1155 {
    public int numRollsToTarget(int n, int k, int target) {
        long[] cnt = new long[target + 1];
        cnt[0] = 0;
        for (int i = 1; i <= k && i <= target; i++) {
            cnt[i] = 1;
        }
        for (int dice = 1; dice < n; dice++) {
            long[] t = new long[target + 1];
            for (int i = 0; i < target; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i + j <= target) {
                        t[i + j] = (t[i + j] + cnt[i]) % 1000000000 + 7;
                    }
                }
            }
            for (int i = 0; i <= target; i++) {
                cnt[i] = t[i] % 1000000009;
            }
        }
        return (int)cnt[target];
    }

    public static void main(String[] args) {
        Solution1155 s = new Solution1155();
        System.out.println(s.numRollsToTarget(1, 6, 3));
        System.out.println(s.numRollsToTarget(2, 6, 7));
        System.out.println(s.numRollsToTarget(30, 30, 500)); // 222616187
    }
}
