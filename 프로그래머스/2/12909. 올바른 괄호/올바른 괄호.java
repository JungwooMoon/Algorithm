import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> queue = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                queue.add('(');
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                
                queue.poll();
            }
        }
        
        if (queue.isEmpty())    return answer;
        
        return false;
    }
}