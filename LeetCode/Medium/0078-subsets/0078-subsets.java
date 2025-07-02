import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> cur, int s, int[] nums) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        ans.add(new ArrayList<>(cur));

        for (int i = s; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(ans, cur, i+1, nums);
            cur.remove(cur.size()-1);
        }
    }
}