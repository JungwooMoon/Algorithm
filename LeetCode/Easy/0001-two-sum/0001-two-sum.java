import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            }

            map.put(need, i);
        }

        return null;
    }
}