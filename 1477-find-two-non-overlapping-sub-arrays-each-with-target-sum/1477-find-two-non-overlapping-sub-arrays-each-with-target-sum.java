class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int left = 0;
        int sum = 0;

        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int shortest = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (left < right && sum > target) {
                sum = sum - arr[left];
                left++;
            }
            if(sum == target) {
                int length = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + best[left - 1]);
                }
                shortest = Math.min(shortest, length);
            }
            best[right] = shortest;
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return ans;
        }
    }
}