class Solution {

    public boolean correct(int[] sfreq, int[] tfreq) {
        for(int i = 0; i < 256; i++) {
            if(sfreq[i] < tfreq[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;

        int[] sfreq = new int[256];
        int[] tfreq = new int[256];

        for (int i = 0; i < m; i++) {
            tfreq[t.charAt(i)]++;
        }

        for(high = 0; high < n; high++) {
            sfreq[s.charAt(high)]++;

            while(correct(sfreq, tfreq)) {
                int length = high - low + 1;
                if(result > length) {
                    result = length;
                    start = low;
                }
                sfreq[s.charAt(low)]--;
                low++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return "";
        }
        else {
            String sFinal = s.substring(start, start + result);
            return sFinal;
        }
    }
}