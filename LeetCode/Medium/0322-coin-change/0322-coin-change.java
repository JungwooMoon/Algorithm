class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[10001];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                }
            }
        }

        if (dp[amount] > amount) return -1;
        return dp[amount];
    }
}