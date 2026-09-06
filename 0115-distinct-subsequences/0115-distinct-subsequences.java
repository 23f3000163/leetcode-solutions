class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        // -1 means we haven't calculated it yet
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return count(s, t, 0, 0);
    }

    int count(String s, String t, int i, int j) {

        // We matched all of t
        if (j == t.length()) {
            return 1;
        }

        // We finished s before matching t
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            dp[i][j] =
                count(s, t, i + 1, j + 1)
                +
                count(s, t, i + 1, j);

        } else {

            dp[i][j] = count(s, t, i + 1, j);
        }

        return dp[i][j];
    }
}