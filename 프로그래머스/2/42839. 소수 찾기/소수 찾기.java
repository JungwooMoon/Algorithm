import java.util.*;

class Solution {
    
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, visited, "", set);
        return set.size();
    }
    
    public void dfs(String numbers, boolean[] visited, String cur, Set<Integer> set) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur += numbers.charAt(i);
                int num = Integer.parseInt(cur);
                if (isPrime(num)) set.add(num);
                dfs(numbers, visited, cur, set);
                visited[i] = false;
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
    
    public boolean isPrime(int num) {
        
        if (num == 0 || num == 1) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}