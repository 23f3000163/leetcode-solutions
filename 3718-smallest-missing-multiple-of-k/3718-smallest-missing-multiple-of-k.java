class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(nums[i] % k == 0) {
                st.add(nums[i]);
            }
        }
        
        int val = k;
        while (st.contains(val)) {
            val = val + k;
        }

        return val;
    }
}