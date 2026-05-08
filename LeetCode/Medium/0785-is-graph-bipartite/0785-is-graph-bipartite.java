import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        


        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                color[i] = true;
            }
            

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                        color[next] = !color[cur];
                    } else {
                        if (color[next] == color[cur]) return false;
                    }
                }
            }

        }

        
        return true;

    }
}