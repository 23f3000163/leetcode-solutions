class Solution {

    private boolean isValid(String current) {
        int sum = 0;
        for (char ch : current.toCharArray()) {
            if (ch =='(') {
                sum++;
            } else {
                sum--;
            }
            
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }

    private void solve(String current, int n, int length, List<String> result) {
        if(length == 2*n) {
            if(isValid(current)) {
                result.add(current);
            }
            return;
        }

        current += '(';
        solve(current, n, length + 1, result);

        //BACKTRACKING
        current = current.substring(0, current.length() - 1);

        current += ')';
        solve(current, n, length + 1, result);

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        solve("", n, 0, result);
        return result;
    }
}