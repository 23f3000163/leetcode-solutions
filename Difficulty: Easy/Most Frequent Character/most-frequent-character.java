class Solution {
    public static char getMaxOccuringChar(String s) {
        // code here
        int n = s.length();
        
        char maxChar = '\0';
        int maxFreq = 0;
        
        HashMap <Character, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (char ch : freq.keySet()) {
            
            if (freq.get(ch) > maxFreq) {
                maxFreq = freq.get(ch);
                maxChar = ch;
            }
            
            else if (freq.get(ch) == maxFreq && ch < maxChar) { //If this character has the same maximum frequency,
                                                                //  check whether it is lexicographically smaller.
                maxChar = ch;
            }
        }
        return maxChar;
    }
}