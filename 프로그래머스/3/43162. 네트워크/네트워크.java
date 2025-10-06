import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
         boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)  {
            graph.add(new ArrayList<>());
            for (int j = 1; j < computers.length; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(graph, i, visited);
                answer++;
            }
        }
        
        
        return answer;
    }
    
     void bfs(List<List<Integer>> graph, int s, boolean[] visited) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(s);
        visited[s] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            List<Integer> nexts = graph.get(cur);
            
            for (int next : nexts) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        
    }
}
    
 