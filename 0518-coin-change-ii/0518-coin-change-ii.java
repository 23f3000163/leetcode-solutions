class Solution {

    static int solve(int[] coins, int index, int amount, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        if (index >= coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int includeAns = solve(coins, index, amount - coins[index], dp);
        int excludeAns = solve(coins, index+1, amount,dp);
        
        dp[index][amount] = includeAns + excludeAns; 
        return dp[index][amount];
    }

    public int change(int amount, int[] coins) {
        int index = 0;
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(coins, index, amount, dp);
        return ans;
    }
}