class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        int[] nums2 = new int[n];
        
        int oddmf = 0;

        for (int i = 0; i < n; i++){
            if (nums1[i] % 2 != 0) {
                //oddmf = nums1[i];
                return true;
            }
            else {
                return true;
            }
        } 
       return false;
    }
}