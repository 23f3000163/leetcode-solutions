class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        for(char ch: s.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        boolean odd = false;
        int count = 0;
        for (char ch : need.keySet()) {
            if (need.get(ch) % 2 == 0) {
                count = count + need.get(ch);
            } else {
                odd = true;
            }
        }
        if (odd == false) {
            return count;
        }
        for (char ch : need.keySet()) {
            if (need.get(ch) % 2 == 1) {
                count = count + (need.get(ch) - 1);
            }
        }
        return count + 1;
    }
}