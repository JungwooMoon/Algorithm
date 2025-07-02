import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (DFS(board, word, 1, new boolean[board.length][board[0].length], i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean DFS(char[][] board, String word, int len, boolean[][] visited, int x, int y) {

        if (len == word.length()) return true;

        int m = board.length;
        int n = board[0].length;

        visited[x][y] = true;

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0};


        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isValid(m, n, nx, ny)) {
                if (!visited[nx][ny] && word.charAt(len) == board[nx][ny]) {
                    visited[nx][ny] = true;
                    if (DFS(board, word, len+1, visited, nx, ny)) return true;
                    visited[nx][ny] = false;
                }
            }
        }

        return false;
    }

    boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}