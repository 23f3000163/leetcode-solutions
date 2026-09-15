class Solution {
   
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1]; //Each index represents an amount.

        //one way to make 0
        dp[0] = 1;

        for (int amount = 1; amount <= target; amount++) {

            for (int num : nums) {

                if (amount >= num) {
                    dp[amount] += dp[amount - num];
                }
            }
        }

        return dp[target];
    }
}