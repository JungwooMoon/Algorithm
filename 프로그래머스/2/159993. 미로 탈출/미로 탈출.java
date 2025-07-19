import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[] lebber = new int[2];
        for (int i = 0; i < maps.length; i++) {
            String map = maps[i];
            if (map.contains("L")) {
                for (int j = 0; j < map.length(); j++) {
                    if (map.charAt(j) == 'L') {
                        lebber = new int[] {i, j};
                    }        
                }    
            }
        }
        int to_s = bfs(new boolean[maps.length][maps[0].length()], maps, lebber, 'S');
        if (to_s == -1) return -1;
        int to_exit = bfs(new boolean[maps.length][maps[0].length()], maps, lebber, 'E');
        if (to_exit == -1) return -1;
        return to_s + to_exit;
    }
    
    int bfs(boolean[][] visited, String[] maps, int[] start, char end) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (maps[cur[0]].charAt(cur[1]) == end) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}