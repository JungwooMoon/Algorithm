import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permu = new ArrayList<>();

        backTrack(permu, new ArrayList<>(), nums);

        return permu;
    }

    void backTrack(List<List<Integer>> ans, List<Integer> cur, int[] nums) {

        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        } 

        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                backTrack(ans, cur, nums);
                cur.remove(cur.size()-1);
            }
        }
    }





    
}