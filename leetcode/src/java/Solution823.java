import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/binary-trees-with-factors/description/?envType=daily-question&envId=2024-01-02
* 823. Binary Trees With Factors
Medium
3.3K
250
Companies
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.



Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].


Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
All the values of arr are unique.
* */
public class Solution823 {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1000000007;
        Arrays.sort(arr);
        HashMap<Integer, Long> counts = new HashMap<>();
        long result = 0;
        for (int num : arr) {
            long c = 1;
            int index = 0;
            while (arr[index] <= Math.sqrt(num)) {
                if (num % arr[index] == 0 && counts.containsKey(num / arr[index])) {
                    long t = counts.get(arr[index]) * counts.get(num / arr[index]) % MOD;
                    if (num / arr[index] != arr[index]) {
                        t *= 2;
                    }
                    c = (c + t) % MOD;
                }
                index++;
            }
            result = (result + c) % MOD;
            counts.put(num, c);
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Solution823 s = new Solution823();
        System.out.println(s.numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(s.numFactoredBinaryTrees(new int[]{2,4,5,10}));
    }
}
