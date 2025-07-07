import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        int completed = 0;
        int cur = 0;
        int idx = 0;
        int total = 0;
        while(completed < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= cur) {
                pq.add(jobs[idx]);
                idx++;
            }    
            
            if (!pq.isEmpty()) {
                int[] job = pq.remove();
                cur += job[1];
                total += cur - job[0];
                completed++;
            } else {
                cur = jobs[idx][0];
            }
        }
        return total / jobs.length;
    }
}