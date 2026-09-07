class Solution {
    
    static void getAllSubsequences(String s,int index,StringBuilder output,List<String> ans){
        
        if(index >= s.length()){
            String Subsequences = output.toString();
            ans.add(Subsequences);
            return;
        }
        
        char ch = s.charAt(index);
        //include
        output.append(ch);
        getAllSubsequences(s,index + 1,output,ans);
        //excludd
        output.deleteCharAt(output.length() - 1);
        getAllSubsequences(s,index + 1,output,ans);
    }
    
    public List<String> powerSet(String s) {
        // Code here
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        int index = 0;
        getAllSubsequences(s,index,output,ans);
        Collections.sort(ans);
        return ans;
    }
}