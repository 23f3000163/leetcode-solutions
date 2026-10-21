class Solution {
    public boolean containsDuplicate(int[] nums) {
        int m = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }
}