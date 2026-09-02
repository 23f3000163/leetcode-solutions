class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m < n) {
            return false;
        } 

        int i = 0;
        for (int j = 0; j < m; j++) {
            if(i < n && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == n;

    }
}