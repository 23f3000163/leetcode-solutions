class Solution {

    static boolean isValidAnswer(int[] arr, int k, long maxPages) {

        int studentCount = 1;
        long pages = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > maxPages)
                return false;

            if (pages + arr[i] <= maxPages) {
                pages += arr[i];
            } else {
                studentCount++;
                pages = arr[i];

                if (studentCount > k)
                    return false;
            }
        }

        return true;
    }

    public int findPages(int[] arr, int k) {

        int n = arr.length;

        if (k > n)
            return -1;

        long low = 0;
        long high = 0;

        for (int x : arr) {
            low = Math.max(low, (long)x);
            high += x;
        }

        long ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isValidAnswer(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}