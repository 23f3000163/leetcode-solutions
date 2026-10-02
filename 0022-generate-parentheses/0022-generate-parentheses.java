class Solution {

    private void solve(String current, int n, List<String> result, int open, int close) {
        if(current.length() == 2*n) {
            result.add(current);
            return;
        }

        if (open < n) {
            current += '(';
            solve(current, n, result, open + 1, close);
            //BACKTRACKING
            current = current.substring(0, current.length() - 1);
        }

        if (close < open) {
            current += ')';
            solve(current, n, result, open, close + 1);
            //BACKTRACKING
            current = current.substring(0, current.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        solve("", n, result, 0, 0);
        return result;
    }
}