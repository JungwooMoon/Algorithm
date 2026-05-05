import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] ans = new int[temperatures.length];
        
        int idx = 0;

        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> idxs = new ArrayDeque<>();

        temp.add(temperatures[0]);
        idxs.add(idx);

        for (int i = 1; i < temperatures.length; i++) {
            
            while (!temp.isEmpty() && temp.peek() < temperatures[i]) {
                int t = temp.pop();
                idx = idxs.pop();
            
                ans[idx] = i - idx;
            } 

            temp.push(temperatures[i]);
            idxs.push(i);
        
        }

        return ans;
    }
}