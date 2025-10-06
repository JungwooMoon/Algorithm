import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            if (operation.charAt(0) == 'I') {
                int num = Integer.parseInt(parts[1]);
                set.add(num);
            } else if (!set.isEmpty()) {
                if(parts[1].charAt(0) == '-') {
                    set.pollFirst();
                } else {
                    set.pollLast();
                }  
            }
        }
      
          int[] answer = {0, 0};
        
        if (!set.isEmpty()) {
            answer[0] = set.last();
            answer[1] = set.first();
        }
      
        return answer;
    }
}