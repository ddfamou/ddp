/*
https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/?envType=daily-question&envId=2023-12-23
1685. Sum of Absolute Differences in a Sorted Array
    Medium
    2K
    68
    Companies
    You are given an integer array nums sorted in non-decreasing order.

    Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.

    In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).



    Example 1:

    Input: nums = [2,3,5]
    Output: [4,3,5]
    Explanation: Assuming the arrays are 0-indexed, then
    result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
    result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
    result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
    Example 2:

    Input: nums = [1,4,6,8,10]
    Output: [24,15,13,15,21]
*/

import java.util.Arrays;

public class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int preSum = 0;
        int prefixSum = Arrays.stream(nums).sum();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = i * nums[i] - preSum + prefixSum - nums[i] * (nums.length - i);
            preSum += nums[i];
            prefixSum -= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1685 s = new Solution1685();
        System.out.println(Arrays.stream(s.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})).toArray());
    }
}
