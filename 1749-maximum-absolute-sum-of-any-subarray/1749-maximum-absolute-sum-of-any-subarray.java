class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];

        int maxResult = max;
        int minResult = min;

        for (int i = 1; i < n; i++) {
            int prevMax = max;
            int prevMin = min;

            max = Math.max(nums[i] , prevMax + nums[i]);
            min = Math.min(nums[i] , prevMin + nums[i]);

            maxResult = Math.max(maxResult, max);
            minResult = Math.min(minResult, min);
        }
        int absMax = Math.abs(maxResult);
        int absMin = Math.abs(minResult);

        int result = Math.max(absMax, absMin);
        return result;
    }
}