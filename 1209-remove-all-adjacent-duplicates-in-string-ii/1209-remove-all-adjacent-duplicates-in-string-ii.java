class Solution {
    class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty()) {
                stack.push(new Pair(c, 1));
                continue;
            }

            if(stack.peek().ch != c) {
                stack.push(new Pair(c, 1));
                continue;
            }

            else {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int j = 0; j < p.count; j++) {
            result.append(p.ch);
            }
        } 
        return result.reverse().toString();
    }
}