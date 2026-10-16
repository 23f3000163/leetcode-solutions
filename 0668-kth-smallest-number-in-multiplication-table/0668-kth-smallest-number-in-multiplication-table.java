class Solution {
    private boolean countAtMost(int m, int n, int mid, int k) {

        int full = Math.min(m, mid / n);
        int count = full * n;

        if (count >= k) {
            return true;
        }

        for (int i = full + 1; i <= m; i++) {
            count += mid / i;

            if (count >= k) {
                return true;
            }
        }

        return false;
    }
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int low = 1;
        int high = m * n;
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countAtMost(m, n, mid, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}