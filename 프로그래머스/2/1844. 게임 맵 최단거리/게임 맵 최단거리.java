import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int []> queue = new ArrayDeque<> ();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        queue.offer(new int[] {0, 0, 1});
        
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == maps.length-1 && cur[1] == maps[0].length-1) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int n_x = cur[0] + dx[i];
                int n_y = cur[1] + dy[i];
                if (isValid(n_x, n_y, maps.length, maps[0].length)) {
                    if (maps[n_x][n_y] == 1 && !visited[n_x][n_y]) {
                        queue.offer(new int[] { n_x, n_y, cur[2]+1 });
                        visited[n_x][n_y] = true;
                    }
                }
            }
            
            
        }
        
        
        return -1;
    }
    
    boolean isValid(int x, int y, int lengthX, int lengthY) {
        return (x >= 0 && x < lengthX) && (y >= 0 && y < lengthY); 
    }
}