class Solution {

    static void solve(String digits, int index, StringBuilder result, List<String> output, String[] mapping) {
            if (index >= digits.length()) {
                output.add(result.toString());
                return;
            }

            int digit = digits.charAt(index) - '0';
            String mapped = mapping[digit];
        
            for (int i = 0; i < mapped.length(); i++) {
                char ch = mapped.charAt(i);
                result.append(ch);
                solve(digits, index + 1, result, output, mapping);
                //backtraking
                result.deleteCharAt(result.length() - 1);
            }
        }

    public List<String> letterCombinations(String digits) {

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        StringBuilder result = new StringBuilder();
        List<String> output = new ArrayList<>();

        int index = 0;
        solve(digits, index, result, output, mapping);
        
        //output.add(result.toString()); 
        return output;
    }
}