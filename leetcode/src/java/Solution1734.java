/*https://leetcode.com/problems/decode-xored-permutation/description/
1734. Decode XORed Permutation
    Medium
    736
    24
    Companies
    There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.

    It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].

    Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.



    Example 1:

    Input: encoded = [3,1]
    Output: [1,2,3]
    Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
    Example 2:

    Input: encoded = [6,5,4,6]
    Output: [2,4,1,5,3]


    Constraints:

    3 <= n < 105
    n is odd.*/

public class Solution1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[0] ^= i;
        }
        int i = 1;
        while (i < encoded.length) {
            res[0] ^= encoded[i];
            i += 2;
        }
        for (i = 0; i < encoded.length; i++) {
            res[i + 1] = encoded[i] ^ res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1734 s = new Solution1734();
        s.decode(new int[]{3, 1});
        s.decode(new int[]{6, 5, 4, 6});

    }
}
