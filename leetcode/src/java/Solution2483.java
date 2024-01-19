/*
https://leetcode.com/problems/minimum-penalty-for-a-shop/?envType=daily-question&envId=2023-12-27
2483. Minimum Penalty for a Shop
    Medium
    1.8K
    90
    Companies
    You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

    if the ith character is 'Y', it means that customers come at the ith hour
    whereas 'N' indicates that no customers come at the ith hour.
    If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

    For every hour when the shop is open and no customers come, the penalty increases by 1.
    For every hour when the shop is closed and customers come, the penalty increases by 1.
    Return the earliest hour at which the shop must be closed to incur a minimum penalty.

    Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.



    Example 1:

    Input: customers = "YYNY"
    Output: 2
    Explanation:
    - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
    - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
    - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
    - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
    - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
    Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
    Example 2:

    Input: customers = "NNNNN"
    Output: 0
    Explanation: It is best to close the shop at the 0th hour as no customers arrive.
    Example 3:

    Input: customers = "YYYY"
    Output: 4
    Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.
*/

public class Solution2483 {
    public int bestClosingTime(String customers) {
        int[] y = new int[customers.length() + 1];
        int[] n = new int[customers.length() + 1];
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                n[i + 1] = n[i] + 1;
            } else {
                n[i + 1] = n[i];
            }
        }
        for (int i = customers.length() - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                y[i] = y[i + 1] + 1;
            } else {
                y[i] = y[i + 1];
            }
        }
        int res = 0;
        for (int i = 1; i <= customers.length(); i++) {
            if (y[i] + n[i] < y[res] + n[res]) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2483 s = new Solution2483();
        System.out.println(s.bestClosingTime("YYNY"));
        System.out.println(s.bestClosingTime("NNNNN"));
        System.out.println(s.bestClosingTime("YYYY"));
    }
}
