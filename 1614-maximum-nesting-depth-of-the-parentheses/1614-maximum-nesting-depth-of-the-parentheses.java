class Solution {
    public int maxDepth(String s) {

        int n = s.length();   
        // Stack<Integer> digit = new Stack<>();
        // Stack<Character> characters = new Stack<>();
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            if (ch == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}