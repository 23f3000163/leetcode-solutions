class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];

        int i = 0;
        int j = n;
        int idx = 0;
        

        while (i < n && j < 2*n) {
            ans[idx] = nums[i];
            i++;
            idx++;
            ans[idx] = nums[j];
            j++;
            idx++;
        }
        return ans;
    }
}