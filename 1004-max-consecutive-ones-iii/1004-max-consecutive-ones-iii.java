class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int low = 0;
        int high = 0;
        int maxLength = Integer.MIN_VALUE;
        int zeroCount = 0;

        for (high = 0; high < n; high++) {
            if (nums[high] == 0) {
                zeroCount++;
            }

            int length = high - low + 1;
            int diff = length - zeroCount;

            while(zeroCount > k) {
                if (nums[low] == 0) {
                    zeroCount--;
                }
                low++;
                length = high - low + 1;
                diff = length - zeroCount;
            }
            length = high - low + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}