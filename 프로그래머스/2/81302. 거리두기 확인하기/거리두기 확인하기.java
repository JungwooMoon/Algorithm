import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        boolean pass;
        for(int u = 0; u < 5; u++) {
            String[] place = places[u];
            pass = true;
            for (int i = 0; i < 5; i++) {
                if (!pass) break;
                if (place[i].contains("P")) {
                    for (int j = 0; j < 5; j++) {
                       if (place[i].charAt(j) == 'P') {
                           if (!isValid(i, j, place)) {
                               pass = false;
                               break;
                           }
                       } 
                    }
                }
            }
            if (pass) answer[u] = 1; 
        }
        
        return answer;
    }
    
    boolean isValid(int x, int y, String[] place) {
        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y, 0});
        
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            
            if (cur[2] == 2) continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (!visited[nx][ny]) {
                        if (place[nx].charAt(ny) == 'P') {
                            return false;
                        } else if (place[nx].charAt(ny) == 'O') {
                            queue.offer(new int[] {nx, ny, cur[2] + 1});    
                        } 
                    }
                }
            }
        }
        
        return true;
    }
}