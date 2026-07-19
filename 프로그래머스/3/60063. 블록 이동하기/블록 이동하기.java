import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int n = board.length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[] rob = new int[] {0, 0, 0, 1, 0, 0};
        
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        boolean[][][][] visited = new boolean[n][n][n][n];
        
        queue.offer(rob);
        visited[0][0][1][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int y1 = cur[0];
            int x1 = cur[1];
            int y2 = cur[2];
            int x2 = cur[3];
            int state = cur[4];
            int t = cur[5];
            
            if ((x1 == n-1 && y1 == n-1) || (x2 == n-1 && y2 == n-1)) {
                return t;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i];
                int nx2 = x2 + dx[i];
                int ny1 = y1 + dy[i];
                int ny2 = y2 + dy[i];
                
                if (isValid(nx1, nx2, ny1, ny2, n) && !visited[nx1][ny1][nx2][ny2]
                   && board[ny1][nx1] == 0 && board[ny2][nx2] == 0) {
                    queue.offer(new int[] {ny1, nx1, ny2, nx2, state, t+1});
                    visited[nx1][ny1][nx2][ny2] = true;
                }
            }
            
            if (state == 0) {
                int nx1 = x2;
                
                if (isValid(nx1, x2, y1+1, y2, n) && !visited[nx1][y1+1][x2][y2]
                   && board[y1+1][nx1] == 0 && board[y1+1][x1] == 0) {
                    queue.offer(new int[] {y1+1, nx1, y2, x2, 1, t+1});
                    visited[nx1][y1+1][x2][y2] = true;
                }
                
                if (isValid(nx1, x2, y1-1, y2, n) && !visited[nx1][y1-1][x2][y2]
                   && board[y1-1][nx1] == 0 && board[y1-1][x1] == 0) {
                    queue.offer(new int[] {y1-1, nx1, y2, x2, 1, t+1});
                    visited[nx1][y1-1][x2][y2] = true;
                }
                
                int nx2 = x1;
                
                if (isValid(x1, nx2, y1, y2+1, n) && !visited[x1][y1][nx2][y2+1]
                   && board[y2+1][nx2] == 0 && board[y2+1][x2] == 0) {
                    queue.offer(new int[] {y1, x1, y2+1, nx2, 1, t+1});
                    visited[x1][y1][nx2][y2+1] = true;
                }
                
                if (isValid(x1, nx2, y1, y2-1, n) && !visited[x1][y1][nx2][y2-1]
                   && board[y2-1][nx2] == 0 && board[y2-1][x2] == 0) {
                    queue.offer(new int[] {y1, x1, y2-1, nx2, 1, t+1});
                    visited[x1][y1][nx2][y2-1] = true;
                }
                
            } else {
                int ny1 = y2;
                
                if (isValid(x1+1, x2, ny1, y2, n) && !visited[x1+1][ny1][x2][y2]
                   && board[ny1][x1+1] == 0 && board[y1][x1+1] == 0) {
                    queue.offer(new int[] {ny1, x1+1, y2, x2, 0, t+1});
                    visited[x1+1][ny1][x2][y2] = true;
                }
                
                if (isValid(x1-1, x2, ny1, y2, n) && !visited[x1-1][ny1][x2][y2]
                   && board[ny1][x1-1] == 0 && board[y1][x1-1] == 0) {
                    queue.offer(new int[] {ny1, x1-1, y2, x2, 0, t+1});
                    visited[x1-1][ny1][x2][y2] = true;
                }
                
                int ny2 = y1;
                
                if (isValid(x1, x2+1, y1, ny2, n) && !visited[x1][y1][x2+1][ny2]
                   && board[ny2][x2+1] == 0 && board[y2][x2+1] == 0) {
                    queue.offer(new int[] {y1, x1, ny2, x2+1, 0, t+1});
                    visited[x1][y1][x2+1][ny2] = true;
                }
                
                if (isValid(x1, x2-1, y1, ny2, n) && !visited[x1][y1][x2-1][ny2]
                   && board[ny2][x2-1] == 0 && board[y2][x2-1] == 0) {
                    queue.offer(new int[] {y1, x1, ny2, x2-1, 0, t+1});
                    visited[x1][y1][x2-1][ny2] = true;
                }
            }
            
            
        }
        
        return answer;
    }
    
    boolean isValid(int x1, int x2, int y1, int y2, int n) {
        return (x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0 && x1 < n && x2 < n && y1 < n && y2 < n);
    }
}