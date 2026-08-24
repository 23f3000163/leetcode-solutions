class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }


        HashMap <Character, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int windowlength = n;
        int j = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        for (j = 0 ; j < m; j++) {
            char ch = s2.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Make window size correct
            if ( j - i + 1 > n) {
                window.put(s2.charAt(i), window.get(s2.charAt(i)) - 1);

                if(window.get(s2.charAt(i)) == 0) {
                    window.remove(s2.charAt(i));
                }
                i++;
            }
            // Check current window
            if (j - i + 1 ==n) {

                if (window.equals(freq)) {
                    return true;
                }
            }
        } 
        return false;
    }
}