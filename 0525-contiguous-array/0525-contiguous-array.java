class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int diff = 0;
        int result = 0;
        int ones = 0;
        int zeros = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones = ones + 1;
            }
            if (nums[i] == 0) {
                zeros = zeros + 1;
            }
            diff = zeros - ones;

            if (freq.containsKey(diff)) {
                result = Math.max(result, i - freq.get(diff));
            }
            else {
                freq.put(diff, i);
            }
        }
        return result;
    }
}