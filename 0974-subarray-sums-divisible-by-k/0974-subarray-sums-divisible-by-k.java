class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int reminder = sum % k;

            if (reminder < 0) {
                reminder = reminder + k;
            }
            if (freq.containsKey(reminder)) {
                result += freq.get(reminder);
            }
            freq.put(reminder, freq.getOrDefault(reminder, 0) + 1);
            
        }
        return result;
    }
}