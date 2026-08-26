class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int low = 0;
        int high = 0;
        int ones = 0;

        String result = "";

        for(high = 0; high < n; high++) {
            if(s.charAt(high) == '1') {
                ones = ones + 1;
            }

            while (low <= high && (ones > k || s.charAt(low) == '0')) {
                if (s.charAt(low) == '1') {
                    ones = ones - 1;
                }
                low++;
            }
            if (ones == k) {
                
                int len = high - low + 1;
                String temp = s.substring(low, high + 1);
                
                if(result.isEmpty() || len < result.length() || (len == result.length() && temp.compareTo(result) < 0)) {
                result = temp;
                }
            }
        }
        return result;
    }
}