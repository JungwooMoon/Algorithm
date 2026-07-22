import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> queue = new ArrayDeque<>();
        Queue<Integer> cnt = new ArrayDeque<>();

        queue.offer(begin);
        cnt.offer(0);
        
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int curCnt = cnt.poll();
            
            if (cur.equals(target)) return curCnt;
            
            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                if (isPossible(word, cur) && !visited[i]) {
                    queue.offer(word);
                    cnt.offer(curCnt+1);
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    boolean isPossible(String a, String b) {
        int cnt = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == a.length()-1;
    }
}