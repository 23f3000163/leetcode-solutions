class Solution {
    int countTriplets(int sum, int arr[]) {
        // code here
        Arrays.sort(arr);

        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;

        int result = 0;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements (optional for this problem)

            int left = i + 1;

            int right = n - 1;

            while (left < right) {

                int currentSum = arr[i] + arr[left] + arr[right];

                // int diff = Math.abs(sum - target);

                // if (diff < minDiff) {

                //     minDiff = diff;

                //     result = sum;

                //  }

               if (currentSum < sum) {
                    result = result +  (right - left);
                    left++;
                } else {
                    right--;

                }

            }

        }

        return result;
    }
}