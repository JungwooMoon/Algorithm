class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (n == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i]);
        }
        if (dp[n-1] >= dp[n-2]) return dp[n-1];

        return dp[n-2] ;

    }
}