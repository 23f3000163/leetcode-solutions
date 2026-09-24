class Solution {
    public int smallestIndex(int[] nums) {

        int digit = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int num = nums[i];
            
            while (num > 0) {
                digit = num % 10;
                sum += digit;
                num = num / 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}