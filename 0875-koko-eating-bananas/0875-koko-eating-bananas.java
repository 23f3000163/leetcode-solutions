class Solution {

    static long speed(int[] piles, int speed) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours = hours + (piles[i] / speed);
            if (piles[i] % speed != 0) {
                hours++;
            }
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;

        int high = 0;
        // Find the maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long minHours = speed(piles, mid);
 
            if (minHours <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}