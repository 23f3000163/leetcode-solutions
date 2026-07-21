class Solution {

    static boolean isValidAnswer(int[] arr, int k, long maxPages) {

        int studentCount = 1;
        long pages = 0;

        for (int i = 0; i < arr.length; i++) {
            
            // If a single book has more pages than maxPages,
            // this allocation is impossible.

            if (arr[i] > maxPages) {
                return false;
            }
            
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
        
        // when the books are less than number of students
        if (k > n)
            return -1;

        long low = 0;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        long high = sum;

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