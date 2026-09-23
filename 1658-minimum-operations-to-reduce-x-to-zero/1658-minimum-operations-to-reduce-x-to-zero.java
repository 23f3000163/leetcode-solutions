class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);

        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
            freq.put(totalSum, i);

        }

        if (totalSum < x) {
            return - 1;
        }

        int target = totalSum - x;
        int longest = Integer.MIN_VALUE;
        int sum = 0;

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