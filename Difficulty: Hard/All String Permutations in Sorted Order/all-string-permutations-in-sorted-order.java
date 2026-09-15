class Solution {
    public void solve(String s,String output, ArrayList<String> result) {
        if (s.isEmpty()) {
            result.add(output);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String remString = s.substring(0,i) + s.substring(i + 1);
            solve (remString, output + ch, result);
        }
        
    }
    public ArrayList<String> permutation(String s) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        solve(s, "", result);
        Collections.sort(result);
        return result;
    }
}