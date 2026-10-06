class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int open = 0;
    
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                open++;
            }
        }
        return open + stack.size();
    }
}