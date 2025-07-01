class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int count,int cur, int target) {
        if (count == numbers.length) {
            if (cur == target) answer++;
            return;
        }
        
        dfs(numbers, count+1, cur+numbers[count], target);
        dfs(numbers, count+1, cur-numbers[count], target);
    }
}