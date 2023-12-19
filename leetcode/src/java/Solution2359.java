import java.util.HashSet;
import java.util.Set;

public class Solution2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Set<Integer> link1 = new HashSet<>();
        Set<Integer> link2 = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (node1 == node2) {
                return node1;
            }
            if (link2.contains(node1)) {
                if (link1.contains(node2)) {
                    return Math.min(node1, node2);
                } else {
                    return node1;
                }
            }
            if (link1.contains(node2)) {
                return node2;
            }

            if (node1 >= 0) {
                link1.add(node1);
                node1 = edges[node1];
            }
            if (node2 >= 0) {
                link2.add(node2);
                node2 = edges[node2];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2359 s = new Solution2359();
        System.out.println(s.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(s.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
        System.out.println(s.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));
        System.out.println(s.closestMeetingNode(new int[]{5,4,5,4,3,6,-1}, 0, 1));
    }
}
