class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int n_target = target - nums[i];
            if (map.containsKey(n_target)) {
                if (map.get(n_target) != i) return new int[] { i, map.get(n_target)};
            }
        }

        return null;
    }
}