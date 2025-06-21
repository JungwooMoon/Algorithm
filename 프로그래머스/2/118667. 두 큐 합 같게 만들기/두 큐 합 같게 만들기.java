class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int len1 = queue1.length;
        int len2 = queue2.length;
        
        int n = len1 + len2;
        
        if (len1 == 1) {
            if (queue1[0] != queue2[0]) return -1;
            else return 0;
        }
        
        int s = 0;
        int e = len1;
        
        long sum = 0;
        
        for (int i = 0; i < len1; i++) {
            sum += queue1[i];    
        }
        
        long goal = sum;
        for (int i = 0; i < len2; i++) {
            goal += queue2[i];    
        }
        
        if (goal % 2 != 0) return -1;
        
        goal = goal / 2;
        
        if (sum == goal) {
            return 0;
        } else if (sum > goal) {
            if (s >= len1) sum -= queue2[s-len1];
            else sum -= queue1[s];
            if (s + 1 >= n) s = 0;
            else s++;
        } else {
            if (e >= len1) sum += queue2[e - len1];
            else sum += queue1[e];
            if (e + 1 >= n) e = 0;
            else e++;
        }
        
        int count = 1;
        while(count < 3 * len1) {
            
            if (sum == goal) {
                return count;
            } else if (sum > goal) {
                if (s >= len1) sum -= queue2[s-len1];
                else sum -= queue1[s];
                if (s + 1 >= n) s = 0;
                else s++;
            } else {
                if (e >= len1) sum += queue2[e - len1];
                else sum += queue1[e];
                if (e + 1 >= n) e = 0;
                else e++;
            }
            
            count++;
        }
        
        return -1;
    }
}