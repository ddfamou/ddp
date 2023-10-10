/*
551. Student Attendance Record I
Easy
659
39
Companies
You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
The student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Return true if the student is eligible for an attendance award, or false otherwise.



Example 1:

Input: s = "PPALLP"
Output: true
Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
Example 2:

Input: s = "PPALLL"
Output: false
Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
*/

//https://leetcode.com/problems/student-attendance-record-i/
class Solution551kt {
    fun check(s: String): Boolean {
        var A = 0
        var L = 0
        s.toCharArray().forEach {
            if (it == 'A') {
                A++
                L=0
                if (A >= 2) {
                    return false
                }
            } else if (it == 'L') {
                L++
                if (L >= 3) {
                    return false
                }
            } else {
                L = 0
            }
        }
        return true
    }
}