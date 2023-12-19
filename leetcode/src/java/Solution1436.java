/*
https://leetcode.com/problems/destination-city/?envType=daily-question&envId=2023-12-15
1436. Destination City
    Easy
    1.5K
    81
    Companies
    You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.



    Example 1:

    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    Output: "Sao Paulo"
    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
    Example 2:

    Input: paths = [["B","C"],["D","B"],["C","A"]]
    Output: "A"
    Explanation: All possible trips are:
    "D" -> "B" -> "C" -> "A".
    "B" -> "C" -> "A".
    "C" -> "A".
    "A".
    Clearly the destination city is "A".
    Example 3:

    Input: paths = [["A","Z"]]
    Output: "Z"


    Constraints:

    1 <= paths.length <= 100
    paths[i].length == 2
    1 <= cityAi.length, cityBi.length <= 10
    cityAi != cityBi
    All strings consist of lowercase and uppercase English letters and the space character.*/
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        for (List<String> path : paths) {
            in.add(path.get(0));
            out.add(path.get(1));
        }
        for (String d : out) {
            if (!in.contains(d)) {
                return d;
            }
        }
        return "";

    }
}
