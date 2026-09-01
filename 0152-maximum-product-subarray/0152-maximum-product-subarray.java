class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < n; i++) {

            int tempMax = currentMax;
            // backup/copy of the old currentMax, so we can use the old value after currentMax has been updated.
            
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));

            currentMin = Math.min(nums[i], Math.min(tempMax * nums[i], currentMin * nums[i]));

            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }
}