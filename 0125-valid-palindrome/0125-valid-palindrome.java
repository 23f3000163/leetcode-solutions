class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.append(Character.toLowerCase(ch));
            } 
        }

        int i = 0;
        int j = st.length() - 1;

        while(i <= j) {

            if (st.charAt(i) != st.charAt(j)){
                return false;
            } 
            i++;
            j--;
        }
        return true;
    }
}