class Solution {
    public int lengthOfLastWord(String s) {
        String word = s.strip();
        int length = 0;

        for (int i = word.length() - 1; i >=0 && word.charAt(i) != ' '; i--) {
            length++;
        }
        
        return length;
    }
}