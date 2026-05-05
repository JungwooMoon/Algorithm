import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            map.put(need, i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i != map.get(nums[i])) {
                    return new int[] {i, map.get(nums[i])};
                }
            }
        }

        return null;
    }
}