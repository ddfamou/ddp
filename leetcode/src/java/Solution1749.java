/*1749. Maximum Absolute Sum of Any Subarray
    Medium
    1.2K
    18
    Companies
    You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

    Return the maximum absolute sum of any (possibly empty) subarray of nums.

    Note that abs(x) is defined as follows:

    If x is a negative integer, then abs(x) = -x.
    If x is a non-negative integer, then abs(x) = x.


    Example 1:

    Input: nums = [1,-3,2,3,-4]
    Output: 5
    Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
    Example 2:

    Input: nums = [2,-5,1,-4,3,-2]
    Output: 8
    Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.


    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104*/
public class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int c = 0;
        int res = 0;
        for (int n : nums) {
            c += n;
            if (c < 0) {
                c = 0;
            } else {
                res = Math.max(c, res);
            }
        }
        c = 0;
        for (int n : nums) {
            c -= n;
            if (c < 0) {
                c = 0;
            } else {
                res = Math.max(c, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1749 s = new Solution1749();
        System.out.println(s.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println(s.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}
