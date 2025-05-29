import java.util.*;

class Solution {
    int min;
    
    public int solution(int n, int[][] wires) {
        min = n;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, n, 1);
    
        return min;
    }
    
    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int n, int start) {
        visited[start] = true;
        
        List<Integer> cur = graph.get(start);
        int count = 1;
        for (int i = 0; i < cur.size(); i++) {
            if (!visited[cur.get(i)]) {
                visited[cur.get(i)] = true;
                count += dfs(graph, visited, n, cur.get(i));
            }
        }
        
        min = Math.min(min, Math.abs(n - 2 * count));
        
        return count;
    }
}