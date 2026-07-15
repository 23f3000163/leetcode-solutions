class Solution {
    int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    //UPPERBOUND
    int upperBound(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;

            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    int countFreq(int[] arr, int target) {
        // code here
        int lbIndex = lowerBound(arr, target);
        int ubIndex = upperBound(arr, target);
        
        int countFreq = ubIndex - lbIndex;
        return countFreq;
    }
}
