class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int operation = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int num : nums) {
            operation = operation + (max - num);
        }
        return operation;
    }
}