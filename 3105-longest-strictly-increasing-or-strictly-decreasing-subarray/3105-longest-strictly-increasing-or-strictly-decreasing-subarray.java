class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int incr = 1;
            int j = i + 1;
            while ( j < nums.length && nums[j] > nums[j - 1]) {
                incr++;
                j++;
            }
            
            j = i + 1;
            int decr = 1;
            while ( j < nums.length && nums[j] < nums[j - 1]) {
                decr++;
                j++;
            }
            result = Math.max(result, Math.max(incr, decr));   
        }
        return result;
    }
}