class Solution {

    private boolean solve(HashMap<Character, Integer> need, HashMap<Character, Integer> have) {
        for (char ch: need.keySet()) {
            if (have.getOrDefault(ch, 0) < need.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
       
        HashMap<Character, Integer> need = new HashMap<>(); 
        for (char ch : ransomNote.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> have = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        boolean ans = solve(need, have);
        return ans;
    }
}