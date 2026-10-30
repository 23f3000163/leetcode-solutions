class Solution {
    public int lengthOfLastWord(String s) {
        String result = s.strip();
        int n = result.length();


        int i = n - 1;
        int length = 0;

        while (result.charAt(i) != ' ') {
            if (i > 0) {
                length++;
                i--;
            }
            if (i == 0) {
                length += 1;
                break;
            }
            
        }
        return length;
    }
}