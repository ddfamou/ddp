//https://leetcode.com/problems/steps-to-make-array-non-decreasing/
import java.util.Arrays;
import java.util.Stack;
import kotlin.Pair;

public class Solution2289 {
    public int totalSteps(int[] nums) {
        /*
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        pre[0] = -1;
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            while (index >= 0 && nums[index] <= nums[i]) {
                index = pre[index];
            }
            pre[i] = index;
            if (index >= 0) {
                dp[index] ++;
            }
        }
        return Arrays.stream(dp).max().getAsInt();*/
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int max = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            int cnt = 0;
            while (!stack.isEmpty() && nums[i] > stack.peek().getFirst()) {
                cnt = Math.max(stack.pop().getSecond(), cnt + 1);
            }
            max = Math.max(cnt, max);
            stack.push(new Pair<>(nums[i], cnt));
        }
        return max;
    }

    public int totalSteps2(int[] A) {
        int n = A.length, res = 0, j = -1;
        int dp[] = new int[n], stack[] = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && A[i] > A[stack[j]]) {
                dp[i] = Math.max(++dp[i], dp[stack[j--]]);
                res = Math.max(res, dp[i]);
            }
            stack[++j] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2289 s = new Solution2289();
        //System.out.println(s.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
        System.out.println(s.totalSteps(new int[]{1682,63,124,147,897,1210,1585,1744,1764,1945,323,984,1886,346,481,1059,1388,1483,1516,1842,1868,1877,504,1197,785,955,970,1848,1851,398,907,995,1167,1214,1423,1452,1464,1474,1311,1427,1757,1992,57,1625,1260,700,725}));
        System.out.println(s.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
        System.out.println(s.totalSteps(new int[]{7,14,4,14,13,2,6,13}));
    }
}
