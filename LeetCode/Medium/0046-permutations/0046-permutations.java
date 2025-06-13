import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backTrack(new ArrayList<>(), nums);    
    }

    List<List<Integer>> backTrack(List<Integer> cur, int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return ans;
        } 

        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                ans.addAll(backTrack(cur, nums));
                cur.remove(cur.size()-1);
            }
        }
        return ans;
    }





    
}