import java.util.HashSet;
import java.util.Stack;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int currentMin = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < currentMin) {
                return true;
            }
            while (!s.isEmpty() && nums[i] > s.peek()) {
                currentMin = s.pop();
            }
            s.push(nums[i]);
        }
        /*
        Stack<Integer> s = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                return true;
            }
            while (!s.isEmpty() && s.peek())
        }

        */
        return false;
    }

    public static void main(String[] args) {
        Solution456 s = new Solution456();
        //System.out.println(s.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(s.find132pattern(new int[]{3,1,4,2}));
        System.out.println(s.find132pattern(new int[]{-1,3,2,0}));
        System.out.println(s.find132pattern(new int[]{1, 0, 1, -4, -3}));
        System.out.println(s.find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
    }
}
