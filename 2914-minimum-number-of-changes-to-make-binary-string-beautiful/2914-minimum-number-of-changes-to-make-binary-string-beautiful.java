class Solution {
    public int minChanges(String s) {
        int n = s.length();

        //int count = 1;
        int change = 0;
        int i = 0;
        
        while (i < n && i + 1 < n) {
            if (s.charAt(i) == s.charAt(i+1)) {
                i = i + 2;
            }
            else if (s.charAt(i) != s.charAt(i+1)) {
                change++;
                i = i + 2;
            }
        }
        return change;
    }
}