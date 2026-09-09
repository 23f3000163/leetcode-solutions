class Solution {

    static Boolean[][] dp;

    static boolean solve(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean includeAns = solve(nums, index + 1, target - nums[index]);
        boolean excludeAns = solve(nums, index + 1, target);

        return dp[index][target] = includeAns || excludeAns;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int index = 0;
        
        for (int i = 0;i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        
        dp = new Boolean[nums.length][target + 1];

        boolean ans = solve(nums, index, target);
        return ans;

    }
}