/*
https://leetcode.com/problems/calculate-money-in-leetcode-bank/?envType=daily-question&envId=2023-12-23
1716. Calculate Money in Leetcode Bank
    Easy
    1.4K
    46
    Companies
    Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

    He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
    Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.



    Example 1:

    Input: n = 4
    Output: 10
    Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
    Example 2:

    Input: n = 10
    Output: 37
    Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
    Example 3:

    Input: n = 20
    Output: 96
    Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
*/

public class Solution1716 {
    public int totalMoney(int n) {
        // todo
        int w = n / 7;
        int d = n % 7;
        int result = (28 + 21 + 7 * w) * w / 2;
        System.out.println(result);
        result += (w + 1 + w + d) * d / 2;

        return result;

    }

    public static void main(String[] args) {
        Solution1716 s = new Solution1716();
        System.out.println(s.totalMoney(4));
        System.out.println(s.totalMoney(10));
        System.out.println(s.totalMoney(20));
    }
}
