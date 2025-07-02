import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    void dfs(List<List<Integer>> ans, int[] nums, boolean[] visited, List<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                dfs(ans, nums, visited, cur);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }
}