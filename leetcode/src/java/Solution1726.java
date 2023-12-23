import java.util.HashMap;
import java.util.Map;

public class Solution1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Long, Integer> product = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long p = nums[i] * nums[j];
                if (product.containsKey(p)) {
                    res += product.get(p) * 8;
                    product.put(p, product.get(p) + 1);
                } else {
                    product.put(p, 1);
                }
            }
        }
        return res;
    }
}
