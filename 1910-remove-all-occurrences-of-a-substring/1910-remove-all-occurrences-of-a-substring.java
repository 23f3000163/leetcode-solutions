class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();

        if (n < m || n == 0) {
            return s;
        }

        while (s.contains(part)) {
            int index = s.indexOf(part);

            s = s.substring(0, index) + s.substring(index + m);

        }

        return s;
    }
}