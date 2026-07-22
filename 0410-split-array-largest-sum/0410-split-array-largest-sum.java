class Solution {

    static boolean isValidAnswer(int[] nums, int k, int maxSubArray) {
        int subarraycounter = 1;
        int sums = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > maxSubArray) {
                return false;
            } 

            if(sums + nums[i] <= maxSubArray) {
                sums += nums[i];
            } else {
                subarraycounter++;
                sums = 0;

                if (subarraycounter > k) {
                    return false;
                }
                sums += nums[i]; 
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int sum = 0;
        int ans = -1;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int e = sum;

        while(s <= e) {
            int m = s + (e - s) / 2;

            if(isValidAnswer(nums, k, m)) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}