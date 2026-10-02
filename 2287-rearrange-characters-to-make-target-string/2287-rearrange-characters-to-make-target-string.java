class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> have = new HashMap<>(); 

        for (char ch: s.toCharArray()) {
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> need = new HashMap<>(); 
        for (char ch: target.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        
        int result = Integer.MAX_VALUE;

        for (char ch : need.keySet()) {
            int needCount = need.get(ch);
            int haveCount = have.getOrDefault(ch, 0);
            int times = haveCount / needCount;
            result = Math.min(result, times);

        }
        return result;
    }
}