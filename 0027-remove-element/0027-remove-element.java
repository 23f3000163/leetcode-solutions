class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length; 

        int i = 0;
        int j = n - 1;

        while(i <= j) {
            if(nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            else if (nums[i] != val) {
                i++;
            }
            else {
                j--;
            }
        }
        int x;
        for (x = 0; x < n; x++) {
            if (nums[x] == val){
                return x;
            }
        }
        return x + 1;
    }
}