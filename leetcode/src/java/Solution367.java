public class Solution367 {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int m = 1;
        int t = 1;
        while (t > 0 && t < num) {
            m = m * 2;
            t = t * 4;
        }
        if (t == num) {
            return true;
        }
        return isPerfectSquare(num, m/2, m);
    }

    public boolean isPerfectSquare(int num, int s, int l) {
        int mid = (l - s) / 2 + s;
        if (mid == s || mid == l) {
            return false;
        }
        if (mid * mid == num) {
            return true;
        }
        if (mid * mid > num || mid * mid < 0) {
            return isPerfectSquare(num, s, mid);
        } else {
            return isPerfectSquare(num, mid, l);
        }
    }
    public static void main(String[] args) {
        Solution367 s = new Solution367();
        System.out.println(s.isPerfectSquare(2147395600));//46340
        System.out.println(s.isPerfectSquare(808201));
        System.out.println(s.isPerfectSquare(1122312));
        System.out.println(s.isPerfectSquare(1923840198));
        System.out.println(s.isPerfectSquare(Integer.MAX_VALUE));
        System.out.println(s.isPerfectSquare(10000));
    }
}

