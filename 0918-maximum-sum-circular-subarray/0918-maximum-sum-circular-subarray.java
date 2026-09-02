class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int max = nums[0]; // Best subarray sum ending here
        int min = nums[0]; // Smallest subarray sum ending here

        int maxResult = nums[0]; // Maximum subarray sum found so far
        int minResult = nums[0]; // Minimum subarray sum found so far

        int totalSum = nums[0]; // Sum of all elements

        for (int i = 1; i < nums.length; i++) {
            totalSum = totalSum + nums[i];  // Add current element to total sum
            
            //int prevMax = max;
            //int prevMin = min;
            
            max = Math.max(nums[i] , max + nums[i]);
            min = Math.min(nums[i] , min + nums[i]);

            maxResult = Math.max(maxResult, max);
            minResult = Math.min(minResult, min);
        }

        if (maxResult < 0) {
            return maxResult;
        }
        int circular = totalSum - minResult;
 
        return Math.max(circular, maxResult);
    }
}