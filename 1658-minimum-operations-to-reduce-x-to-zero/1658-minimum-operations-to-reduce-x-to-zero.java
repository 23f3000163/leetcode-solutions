class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            freq.put(sum, i);

        }

        if (sum < x) {
            return - 1;
        }

        int target = sum - x;
        int longest = Integer.MIN_VALUE;
        sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int ques = sum - target;
            if (freq.containsKey(ques)) {
                longest = Math.max(longest, i - freq.get(ques));
            }
        }
        if (longest == Integer.MIN_VALUE) {
            return -1;
        } else {
            return n - longest;
        }
    }
}