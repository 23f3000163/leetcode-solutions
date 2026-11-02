class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int mid = n / 2;
        int target = nums[mid];
        int operations = 0;

        for (int i = 0; i < n; i++) {
            operations = operations + (Math.abs(target - nums[i]));
        }
        return operations;
    }
}