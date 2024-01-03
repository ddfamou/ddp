/*
https://leetcode.com/problems/path-crossing/?envType=daily-question&envId=2023-12-23
1496. Path Crossing
    Easy
    1.4K
    44
    Companies
    Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

    Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.



    Example 1:


    Input: path = "NES"
    Output: false
    Explanation: Notice that the path doesn't cross any point more than once.
    Example 2:


    Input: path = "NESWW"
    Output: true
    Explanation: Notice that the path visits the origin twice.
*/

import java.util.HashSet;
import kotlin.Pair;

public class Solution1496 {
    public boolean isPathCrossing(String path) {
        HashSet<Pair<Integer, Integer>> s = new HashSet<>();
        int x = 0;
        int y = 0;
        s.add(new Pair<>(0, 0));
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    x++;
                    break;
                case 'W':
                    y--;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
            }
            Pair<Integer, Integer> p = new Pair<>(x, y);
            if (s.contains(p)) {
                return true;
            } else {
                s.add(p);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1496 s = new Solution1496();
        System.out.println(s.isPathCrossing("NES"));
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
