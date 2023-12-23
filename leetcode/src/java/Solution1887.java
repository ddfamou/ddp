import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/*
https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/?envType=daily-question&envId=2023-12-21
1887. Reduction Operations to Make the Array Elements Equal
    Medium
    1.2K
    47
    Companies
    Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:

    Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
    Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
    Reduce nums[i] to nextLargest.
    Return the number of operations to make all elements in nums equal.



    Example 1:

    Input: nums = [5,1,3]
    Output: 3
    Explanation: It takes 3 operations to make all elements in nums equal:
    1. largest = 5 at index 0. nextLargest = 3. Reduce nums[0] to 3. nums = [3,1,3].
    2. largest = 3 at index 0. nextLargest = 1. Reduce nums[0] to 1. nums = [1,1,3].
    3. largest = 3 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1].
    Example 2:

    Input: nums = [1,1,1]
    Output: 0
    Explanation: All elements in nums are already equal.
    Example 3:

    Input: nums = [1,1,2,2,3]
    Output: 4
    Explanation: It takes 4 operations to make all elements in nums equal:
    1. largest = 3 at index 4. nextLargest = 2. Reduce nums[4] to 2. nums = [1,1,2,2,2].
    2. largest = 2 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1,2,2].
    3. largest = 2 at index 3. nextLargest = 1. Reduce nums[3] to 1. nums = [1,1,1,1,2].
    4. largest = 2 at index 4. nextLargest = 1. Reduce nums[4] to 1. nums = [1,1,1,1,1].


    Constraints:

    1 <= nums.length <= 5 * 104
    1 <= nums[i] <= 5 * 104*/
public class Solution1887 {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            if (cnt.containsKey(v)) {
                cnt.put(v, cnt.get(v) + 1);
            } else {
                cnt.put(v, 1);
            }
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (Integer v : cnt.keySet()) {
            list.add(new Pair<>(v, cnt.get(v)));
        }
        list.sort(new PairSort());
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += list.get(i).getSecond() * i;
        }
        return res;
    }
    class PairSort implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
            return a.getFirst() - b.getFirst();
        }
    }

    public static void main(String[] args) {
        Solution1887 s = new Solution1887();
        System.out.println(s.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(s.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(s.reductionOperations(new int[]{1,1,2,2,3}));
        System.out.println(s.reductionOperations(new int[]{5, 1, 3}));
    }
}
