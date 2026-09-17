class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int ques = sum - k;
            if (freq.containsKey(ques)) {
                result += freq.get(ques);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}