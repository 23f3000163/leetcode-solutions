class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i < n) {

            while(i >= 0 && s.charAt(i) == ' ') {
                i++;
            }
            
            if (i < 0 || i > n) {
                break;
            }

            int j = i;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            StringBuilder word = new StringBuilder(s.substring(i, j));
            word.reverse();

            if (ans.length() > 0) {
                ans.append(' ');
            }

            ans.append(word);
            i = j;
        }
        return ans.toString();
    }
}