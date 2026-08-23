class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder reversed = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if(i < 0) {
                break;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            
            
            if(reversed.length() > 0) {
                reversed.append(' ');
            }
            
            reversed.append(s.substring(j+1, i+1));
            i = j;
        }
        return reversed.toString();
    }
}