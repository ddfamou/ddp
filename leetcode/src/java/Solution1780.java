/*1780. Check if Number is a Sum of Powers of Three
    Medium
    930
    30
    Companies
    Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

    An integer y is a power of three if there exists an integer x such that y == 3x.



    Example 1:

    Input: n = 12
    Output: true
    Explanation: 12 = 31 + 32
    Example 2:

    Input: n = 91
    Output: true
    Explanation: 91 = 30 + 32 + 34
    Example 3:

    Input: n = 21
    Output: false


    Constraints:

    1 <= n <= 107*/

public class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        int t = n;
        int n3 = 1;
        while (n3 < n) {
            n3 *= 3;
        }
        while (n3 > 0) {
            if (t >= n3) {
                t -= n3;
            }
            n3 /= 3;
        }
        return t == 0;
    }
}
