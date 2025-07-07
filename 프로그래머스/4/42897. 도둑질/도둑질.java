class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        if (money.length == 0) return 0;
        if (money.length == 1) return money[0];
        if (money.length == 2) return Math.max(money[0], money[1]);
        
        dp[0] = money[0];
        dp[1] = Math.max(money[1], dp[0]);
        
        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        
        int[] dp2 = new int[money.length];
        
        dp2[1] = money[1];
        dp2[2] = Math.max(money[2], dp2[0]);
        
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp[money.length-2], dp2[money.length-1]);
    }
}