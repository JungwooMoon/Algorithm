class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if (m == 1 || n == 1) return 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i == 0) dp[i][j] = 1;
                else if (j == 0) dp[i][j] = dp[i-1][j];
                else if (i == 0) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}