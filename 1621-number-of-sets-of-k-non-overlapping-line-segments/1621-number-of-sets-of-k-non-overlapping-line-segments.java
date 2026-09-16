class Solution {

    static int M = 1000000007;

    public int numberOfSets(int n, int k) {

        // dp[segments][index]
        int[][] dp = new int[k + 1][n + 1];

        // Base case:
        // 0 segments -> 1 valid way
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        // Build for 1 to k segments
        for (int segments = 1; segments <= k; segments++) {

            int suffix = 0;

            // index = n is already 0
            dp[segments][n] = 0;

            for (int index = n - 1; index >= 0; index--) {

                // Add dp[segments - 1][index + 1]
                // to our suffix sum.
                if (index + 1 < n) {
                    suffix = (suffix + dp[segments - 1][index + 1]) % M;
                }

                // Skip current point
                int skip = dp[segments][index + 1];

                // Take a segment starting at current point
                int take = suffix;

                dp[segments][index] = (skip + take) % M;
            }
        }

        return dp[k][0];
    }
}