class Solution {
    int MOD = 1000000007;
    int[] dp;
    int[] prev;

    public int solve(int n) {
        if (n == 0) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int total = (int)((2L * solve(n - 1)) % MOD);

        if(prev[n] != 0) {
            int duplicates = solve(prev[n] - 1);
            total = (total - duplicates + MOD) % MOD;
        }

        dp[n] = total;
        return total;
        
    }

    public int distinctSubseqII(String s) {
        int n = s.length();
        
        dp = new int[n + 1];
        prev = new int[n + 1];;

        Arrays.fill(dp, -1);

        // lastSeen[0] = 'a', lastSeen[1] = 'b', ...
        int[] lastSeen = new int[26];

        // Store previous occurrence of every character
        for(int i = 1; i <= n; i++) {
            int index = s.charAt(i - 1) - 'a';

            prev[i] = lastSeen[index];
            lastSeen[index] = i;
        }
        return (solve(n) - 1 + MOD) % MOD; // -1 for the empty set    
    }
}