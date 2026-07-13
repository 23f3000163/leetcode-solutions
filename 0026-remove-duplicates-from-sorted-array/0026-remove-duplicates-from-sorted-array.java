class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int i = 0;
        int j = i + 1;
        int unique = 1;

        while(j < n) {
            if(nums[i] == nums[j]){
                j++;
            } else {
                nums[i + 1] = nums[j];
                unique++;
                i++;
                j++;
            }
        }
        return unique;
    }
}