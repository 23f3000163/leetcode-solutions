class Solution {
    public int solve(int[] nums, int target, int start, int end) {
        
        if(start > end) {
            return -1;
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        return solve(nums, target, start, end);

            
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        int ans = solve(nums, target, start, end);
        return ans;
    }
}