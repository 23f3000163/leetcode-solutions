class Solution {
    public boolean checkString(String s) {
        boolean isA = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && isA == false) {
                isA = true;
            }
            if (s.charAt(i) == 'a' && isA == true) {
                return false;
            }
        }
        return true;
    }
}