import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        if(maps[0][0] == 0) return -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0, 0, 1});
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == n-1 && cur[1] == m-1) return cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        queue.offer(new int[] {nx, ny, cur[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}