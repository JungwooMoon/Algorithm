import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean test = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) test = true;
        }
        if (!test) return 0;
        
        Queue<String> queue = new ArrayDeque<>();
        Queue<Integer> count = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(begin);
        count.offer(0);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int cur_count = count.poll();
            if (cur.equals(target)) return cur_count;
            for (int i = 0; i < words.length; i++) {
                int simillar = 0;
                for (int j = 0; j < cur.length(); j++) {
                    if (words[i].charAt(j) == cur.charAt(j)) simillar++;
                }
                if (simillar == cur.length() - 1) {
                    if (!visited[i]) {
                        queue.offer(words[i]);
                        count.offer(cur_count + 1);
                    }
                }
            }
        }
        
        return 0;
    }
    
}