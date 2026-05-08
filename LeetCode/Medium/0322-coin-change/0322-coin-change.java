class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount+1];
        num[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            num[i] = amount + 1; 
        }

        for (int i = 0; i < amount; i++) {
            for (int coin : coins) {
                if (i + coin <= amount && i + coin >= 0) {
                    num[i+coin] = Math.min(num[i+coin], num[i] + 1); 
                }
            }
        }

        return num[amount] == amount + 1 ? -1 : num[amount]; 
    }
}