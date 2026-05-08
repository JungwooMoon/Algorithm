import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new ArrayDeque<>();
        Queue<Integer> cnt = new ArrayDeque<>();
        queue.offer(begin);
        cnt.offer(0);
        boolean[] visited = new boolean[words.length];
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int cur_cnt = cnt.poll();
            for (int i = 0; i < words.length; i++) {
                if (check(cur, words[i]) && !visited[i]) {
                    queue.offer(words[i]);
                    visited[i] = true;
                    cnt.offer(cur_cnt+1);
                    if (target.equals(words[i])) return cur_cnt+1;
                } 
            }
            
        }
        
        
        
        
        return 0;
    }
    
    boolean check(String a, String b) {
        
        int n = 0;
        
        for (int i = 0;  i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) n++;
        }
        
        return n == a.length() - 1;
        
    }
}