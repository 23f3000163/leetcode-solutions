class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < n; i++) {

            if (ans.length() > 0 && s.charAt(i) == ans.charAt(ans.length() - 1)) {
                ans.deleteCharAt(ans.length() - 1);
            }

            else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString(); 
    }
}