class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int k = 3;
        int operation = 0;

        for (int num : nums) {
            int r = num % k;
            operation = operation + Math.min(k - r, r);
        }
        return operation;
    }
}