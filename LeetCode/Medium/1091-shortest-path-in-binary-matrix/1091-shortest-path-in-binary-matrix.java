import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) {
            return -1;
        }
        
        int dx[] = new int[] {0, 0, 1, 1, 1, -1, -1, -1};
        int dy[] = new int[] {1, -1, 0, 1, -1, 0, 1, -1};

        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == grid.length - 1 && cur[1] == grid.length -1) return cur[2];

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (isValid(nx, ny, grid.length)) {
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                    } 
                }
            }
        }
        return -1;
    }

    boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}