class Solution {
    public int maxProduct(int[] nums) {
        
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;


        for(int num : nums) {
            int oldA = a;
            int oldB = b;
           

        a = Math.max(a, num);
        b = Math.max(b, Math.min(oldA, num));

       
        }
        
        return ((a - 1) * (b - 1));
    }
}