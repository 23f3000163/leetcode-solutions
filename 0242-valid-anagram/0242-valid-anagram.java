class Solution {
    public boolean isAnagram(String s, String t) {
        int[] first = new int[26];
        int[] second = new int[26];

        for (char ch: s.toCharArray()) {
            first[ch - 'a']++;
        }

        for (char ch: t.toCharArray()) {
            second[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(first[i] != second[i]) {
                return false;
            } 
        }
        return true;
    }
}