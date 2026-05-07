import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[rooms.size()];

        queue.offer(0);
        visited[0] = true;
        int visit = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int key : rooms.get(cur)) {
                if (!visited[key]) {
                    queue.offer(key);
                    visited[key] = true;
                    visit++;
                }
            }
        }

        return rooms.size() == visit;
    }
}