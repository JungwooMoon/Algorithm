import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        int n = grid.length;

        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, 0, 1, -1, 1, -1, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[] { 0, 0, 1 });
        visited[0][0] = true;

         while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == n-1 && cur[1] == n-1) return cur[2];

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && grid[nx][ny] == 0) {
                        queue.offer(new int[] {nx, ny, cur[2]+1});
                        visited[nx][ny] = true;
                    }
                }   
            }
        }


        return -1;  
    }
}