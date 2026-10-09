class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int count = 0;
        int result = 0;
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
                i++;
            }
            else { // ')'
                if (count > 0) {
                    count--;
                } else {
                    result++; //'insert ')'
                }
                 if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;     // "))" found
                } else {
                    result++;   // insert ')'
                    i++;
                }
            }
        }
        return result + 2*(count);
    }
}