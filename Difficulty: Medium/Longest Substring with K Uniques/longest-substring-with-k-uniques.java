class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int low = 0;
        int high = 0;
        int maxLength = -1;
        HashMap<Character, Integer> characters = new HashMap<>();
        
        for (high = 0; high < n; high++) {
            
            characters.put(s.charAt(high), characters.getOrDefault(s.charAt(high), 0) + 1);
            
            while (characters.size() > k) {
                
                characters.put(s.charAt(low), characters.get(s.charAt(low)) - 1);
                
                if (characters.get(s.charAt(low)) == 0) {
                    characters.remove(s.charAt(low));
                }
                
                low++;
            }
            
            if (characters.size() == k) {
                int length = high - low + 1;

                maxLength = Math.max(maxLength, length);
            }
            
        }
        return maxLength;
    }
}