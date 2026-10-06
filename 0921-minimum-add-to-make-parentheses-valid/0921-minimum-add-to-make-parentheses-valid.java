class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int open = 0;
    
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } 
            else {
                if (s.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        open++;
                    }
                } 
            }
        }
        ans = open + stack.size();
        return ans;
    }
}