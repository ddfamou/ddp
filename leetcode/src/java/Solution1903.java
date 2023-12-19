public class Solution1903 {
    public String largestOddNumber(String num) {
        if (num.length() > 0 && (num.charAt(num.length() - 1) - '0') % 2 == 0) {
            return largestOddNumber(num.substring(0, num.length() - 1));
        } else {
            return num;
        }
    }
}
