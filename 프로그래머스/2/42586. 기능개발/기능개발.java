class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] tmp = new int[n];
        int idx = 0;        
        int day = 1;
        for (int i = 0; i < n-1; i++) {
            
            int count = 1;
            
            while(progresses[i] + speeds[i] * day < 100) {
                day++;
            }
            
            while(i+1 < n && progresses[i+1] + speeds[i+1] * day >= 100) {
                count++;
                i++;
            }
            
            tmp[idx] = count;
            idx++;
        }
        
        if(progresses[n-1] + speeds[n-1] * day < 100) {
                tmp[idx] = 1;
                idx++;
        }
        
        int[] answer = new int[idx];
        
        for (int i = 0; i < idx; i++) {
            answer[i] = tmp[i];
        }
        
        return answer;
    }
}