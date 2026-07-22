import java.util.*;

class Solution {
    
    public int solution(int[] info, int[][] edges) {
        
        Map<Integer, List<Integer>> tree = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
            tree.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);    
        }
        
        Set<Integer> nexts = new HashSet<>();
        
        for (int n : tree.get(0)) {
            nexts.add(n);
        }
        
        int answer = dfs(1, 0, nexts, tree, info);
        
        return answer;
    }
    
    int dfs(int sheep, int wolf, Set<Integer> nexts, Map<Integer, List<Integer>> tree, int[] info) {
       int max = sheep;
        
        for (int next : nexts) {
            List<Integer> candidate = tree.get(next);
            
            Set<Integer> nextCandidate = new HashSet<>(nexts);
            nextCandidate.remove(next);
            
            int n_sheep = sheep;
            int n_wolf = wolf;
            
            if (info[next] == 0) {
                n_sheep++;
            } else {
                n_wolf++;
                if (n_sheep <= n_wolf) continue;
            }

            for (int can : candidate) {
                nextCandidate.add(can);
            }

            max = Math.max(dfs(n_sheep, n_wolf, nextCandidate, tree, info), max);
            
          
        } 
        
        return max;
        
    }
    
    
    
    
}