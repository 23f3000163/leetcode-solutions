class Solution {
    boolean[][] isPalindrome;
    // public boolean isPalindrome(String s, int i, int j) {
    //     while(i <= j) {
    //         if (s.charAt(i++) != s.charAt(j--)) {
    //             return false;
  
    //         }
    //     }
    //     return true;
    // }


    public int solve(String s, int k, int i, int j, int[][] dp) {
        int n = s.length();

        if( i >= n || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (isPalindrome[i][j]) {
            int take = 1 + solve(s, k, j+1, j+k, dp);
            int grow = solve(s, k, i, j+1, dp);
            int slide = solve(s, k, i+1, j+1, dp);

            return dp[i][j] = Math.max(take, Math.max(grow, slide));
        }

        else {
            int grow = solve(s, k, i, j+1, dp);
            int slide = solve(s, k, i+1, j+1, dp);

            return dp[i][j] = Math.max(grow, slide);
        }
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if (k == 1) {
            return n;
        }

        isPalindrome = new boolean[n + 1][n + 1];
        //Palindromic substring Blueprint
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][i] = true; //Single characters are palindrome
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)); //Strings of 2 Length
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, k, 0, k-1, dp);
    }
}