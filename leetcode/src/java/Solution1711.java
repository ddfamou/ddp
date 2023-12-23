import java.util.Arrays;
import java.util.HashMap;

/*https://leetcode.com/problems/count-good-meals/
1711. Count Good Meals
    Medium
    988
    232
    Companies
    A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.

    You can pick any two different foods to make a good meal.

    Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of different good meals you can make from this list modulo 109 + 7.

    Note that items with different indices are considered different even if they have the same deliciousness value.



    Example 1:

    Input: deliciousness = [1,3,5,7,9]
    Output: 4
    Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
    Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
    Example 2:

    Input: deliciousness = [1,1,1,3,3,3,7]
    Output: 15
    Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.


    Constraints:

    1 <= deliciousness.length <= 105
    0 <= deliciousness[i] <= 220*/
public class Solution1711 {
    public int countPairs(int[] deliciousness) {
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        Arrays.sort(deliciousness);
        int currentMax = deliciousness[0];
        m.put(deliciousness[0], 1);
        for (int i = 1; i < deliciousness.length; i++) {
            int power = 1;
            while (power <= currentMax + deliciousness[i]) {
                if (m.containsKey(power - deliciousness[i])) {
                    res += m.get(power - deliciousness[i]);
                }
                power *= 2;
            }
            if (m.containsKey(deliciousness[i])) {
                m.put(deliciousness[i], m.get(deliciousness[i]) + 1);
            } else {
                m.put(deliciousness[i], 1);
            }
            currentMax = deliciousness[i];
            res = res % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1711 s = new Solution1711();
        System.out.println(s.countPairs(new int[]{1,1,1,3,3,3,7}));
        System.out.println(s.countPairs(new int[]{1,3,5,7,9}));
        System.out.println(s.countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));
    }
}
