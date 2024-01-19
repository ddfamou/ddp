import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int index = -1;
        int preValue = nums[0] - 1;
        for (int v: nums) {
            if (v == preValue) {
                index++;
            } else {
                index = 0;
                preValue = v;
            }
            if (result.size() > index) {
                result.get(index).add(v);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(v);
                result.add(l);
            }
        }
        return result;
    }

}
