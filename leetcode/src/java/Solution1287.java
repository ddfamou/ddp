/*https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/?envType=daily-question&envId=2023-12-27
1287. Element Appearing More Than 25% In Sorted Array
    Easy
    1.6K
    73
    Companies
    Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.



    Example 1:

    Input: arr = [1,2,2,6,6,6,6,7,10]
    Output: 6
    Example 2:

    Input: arr = [1,1]
    Output: 1


    Constraints:

    1 <= arr.length <= 104
    0 <= arr[i] <= 105*/
public class Solution1287 {

    public int findSpecialInteger(int[] arr) {
        if (arr.length < 4) {
            return arr[0];
        }
        int step = arr.length / 4;
        for (int i = 0; i + step < arr.length; i++) {
            if (arr[i] == arr[i + step]) {
                return arr[i];
            }
        }
        return -1;
    }
}
