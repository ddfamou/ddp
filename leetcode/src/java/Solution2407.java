//https://leetcode.com/problems/longest-increasing-subsequence-ii/

import java.util.Arrays;

/*2407. Longest Increasing Subsequence II
Hard
780
32
Companies
You are given an integer array nums and an integer k.

Find the longest subsequence of nums that meets the following requirements:

The subsequence is strictly increasing and
The difference between adjacent elements in the subsequence is at most k.
Return the length of the longest subsequence that meets the requirements.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [4,2,1,4,3,4,5,8,15], k = 3
Output: 5
Explanation:
The longest subsequence that meets the requirements is [1,3,4,5,8].
The subsequence has a length of 5, so we return 5.
Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.
Example 2:

Input: nums = [7,4,5,1,8,12,4,7], k = 5
Output: 4
Explanation:
The longest subsequence that meets the requirements is [4,5,8,12].
The subsequence has a length of 4, so we return 4.
Example 3:

Input: nums = [1,5], k = 1
Output: 1
Explanation:
The longest subsequence that meets the requirements is [1].
The subsequence has a length of 1, so we return 1.


Constraints:

1 <= nums.length <= 105
1 <= nums[i], k <= 105
*/
public class Solution2407 {
    public int lengthOfLIS(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        SegmentTree t = new SegmentTree(max + 1);
        t.update(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            t.update(nums[i], t.query(Math.max(0, nums[i] -k), nums[i] - 1) + 1);
        }
        return t.query(0, max);
    }

    class SegmentTree {
        int[] tree;
        int size;

        SegmentTree(int size) {
            this.size = size;
            this.tree = new int[size * 4];
        }

        void update(int loc, int value) {
            update(0, size - 1, loc, 0, value);
        }

        void update(int l, int r, int loc, int node, int value) {
            if (l == r) {
                tree[node] = value;
                return;
            }
            int mid = (l + r) / 2;
            if (mid < loc) {
                // process right subtree
                update(mid + 1, r, loc, 2 * node + 2, value);
            } else {
                // process left sbutree
                update(l, mid, loc, 2 * node + 1, value);
            }
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        int query(int st, int end) {
            return query(0, size - 1, st, end, 0);
        }

        int query(int l, int r, int st, int end, int node) {
            if (l > end || r < st) {
                return 0;
            }
            if (st <= l && r <= end) {
                return tree[node];
            }
            int mid = (l + r) / 2;
            int l_max = query(l, mid, st, end, node * 2 + 1);
            int r_max = query(mid + 1, r, st, end, node * 2 + 2);
            return Math.max(l_max, r_max);
        }
    }


    public static void main(String[] args) {
        Solution2407 s = new Solution2407();
        //System.out.println(s.lengthOfLIS(new int[]{4,2,1,4,3,4,5,8,15}, 3));
        //System.out.println(s.lengthOfLIS(new int[]{7,4,5,1,8,12,4,7}, 5));
        System.out.println(s.lengthOfLIS(new int[]{1, 5}, 1));
    }
}

