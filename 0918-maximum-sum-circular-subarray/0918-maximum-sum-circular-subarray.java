class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;;

        int max = nums[0];
        int min = nums[0];

        int maxResult = max;
        int minResult = min;

        int totalSum = nums[0];

        for (int i = 1; i < n; i++) {
            totalSum = totalSum + nums[i];
            
            int prevMax = max;
            int prevMin = min;

            max = Math.max(nums[i] , prevMax + nums[i]);
            min = Math.min(nums[i] , prevMin + nums[i]);

            maxResult = Math.max(maxResult, max);
            minResult = Math.min(minResult, min);
        }

        if (maxResult < 0) {
            return maxResult;
        }
        int circular = totalSum - minResult;
 
        int ans = Math.max(circular, maxResult);
        
        return ans;
    }
}