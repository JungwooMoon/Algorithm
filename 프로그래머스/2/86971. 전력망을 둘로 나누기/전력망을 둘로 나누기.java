import java.util.*;

class Solution {
    
    int min;
    
    public int solution(int n, int[][] wires) {
        
        min = n;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        
        dfs(map, visited, 1, n);
        
        return min;
    }
    
    int dfs(Map<Integer, List<Integer>> map, boolean[] visited, int start, int n) {
        visited[start] = true;
        
        int count = 1;
        
        List<Integer> nexts = map.get(start);
        
        for(int next : nexts) {
            if (!visited[next]) {
                count += dfs(map, visited, next, n);
            }
        }
        
        min = Math.min(min, Math.abs(n - 2 * count));
        
        return count;
    }
    
}