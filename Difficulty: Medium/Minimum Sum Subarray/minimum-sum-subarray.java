class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int currentSum = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < n; i++) {

            currentSum = Math.min(arr[i], currentSum + arr[i]);

            minSum = Math.min(minSum, currentSum);


        }
        return minSum;
    }
}