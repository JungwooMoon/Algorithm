import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue = new ArrayDeque<>();
        Queue<Integer> count = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length+1];
        queue.offer(begin);
        count.offer(0);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int cnt = count.poll();
            if (cur.equals(target)) return cnt;
            
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if(isPossible(cur, word) && !visited[i]) {
                    visited[i] = true;
                    queue.offer(word);
                    count.offer(cnt + 1);
                }
            }
        }
        return 0;
    }
    
    boolean isPossible(String x, String y) {
        int cnt = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == y.charAt(i)) cnt++;
        }
        
        if (cnt == x.length()-1) return true;
        return false;
    }
}