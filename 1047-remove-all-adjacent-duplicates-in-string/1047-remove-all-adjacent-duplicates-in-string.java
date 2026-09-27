class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}