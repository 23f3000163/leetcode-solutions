class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;
        int maxLength = Integer.MIN_VALUE;

        HashMap<Character, Integer> characters = new HashMap<>();

        if (n == 0) {
            return 0;
        }
        
        for (high = 0; high < n; high++) {
            characters.put(s.charAt(high), characters.getOrDefault(s.charAt(high), 0) + 1);
            
            int k = high - low + 1;

            while (characters.size() < k) {
                
                characters.put(s.charAt(low), characters.get(s.charAt(low)) - 1);
                
                if (characters.get(s.charAt(low)) == 0) {
                    characters.remove(s.charAt(low));
                }
                
                low++;
                k = high - low + 1;
            } 

            if(characters.size() == k) {
                int len = high - low + 1;

                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
}