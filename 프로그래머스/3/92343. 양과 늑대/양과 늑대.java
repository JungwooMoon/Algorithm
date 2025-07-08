import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        Map<Integer, Node> tree = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
            tree.put(i, new Node());
        }
        
        for (int[] edge : edges) {
            if (tree.get(edge[0]).left >= 0) tree.get(edge[0]).right = edge[1];
            else tree.get(edge[0]).left = edge[1];
        }
    
        int[] max = dfs(info, new int[] {0, 0, 0}, tree);
        return max[0];
    }
    
    int[] dfs(int[] info, int[] cur, Map<Integer, Node> tree) {
        int wolf = cur[1];
        int sheep = cur[0];
        if (info[cur[2]] == 0) sheep++;
        else wolf++;
        if (sheep <= wolf) return cur;
        
        Node curNode = tree.get(cur[2]);
        int[] cnt1 = new int[3];
        int[] cnt2 = new int[3];
        
        if (tree.get(cur[2]).left < 0) return new int[] {sheep, wolf, 0};
        cnt1 = dfs(info, new int[] {sheep, wolf, curNode.left}, tree);
        if (tree.get(cur[2]).right >= 0) cnt1 = dfs(info, new int[] {cnt1[0], cnt1[1], curNode.right}, tree);
        
        if (tree.get(cur[2]).right >= 0) cnt2 = dfs(info, new int[] {sheep, wolf, curNode.right}, tree);
        cnt2 = dfs(info, new int[] {cnt2[0], cnt2[1], curNode.left}, tree);
        
        
        int max = Math.max(cnt1[0], cnt2[0]);
        
        while(max != sheep) {
            sheep = max;
           if (tree.get(cur[2]).left < 0) return new int[] {sheep, wolf, 0};
            cnt1 = dfs(info, new int[] {sheep, wolf, curNode.left}, tree);
            if (tree.get(cur[2]).right >= 0) cnt1 = dfs(info, new int[] {cnt1[0], cnt1[1], curNode.right}, tree);

            if (tree.get(cur[2]).right >= 0) cnt2 = dfs(info, new int[] {sheep, wolf, curNode.right}, tree);
            cnt2 = dfs(info, new int[] {cnt2[0], cnt2[1], curNode.left}, tree);


            max = Math.max(cnt1[0], cnt2[0]); 
        }
        
        return new int[] {max, wolf, 0};
         
    }
    
    class Node {
        int left;
        int right;
        
        Node() {
            left = -1;
            right = -1;
        }
    }
    
}