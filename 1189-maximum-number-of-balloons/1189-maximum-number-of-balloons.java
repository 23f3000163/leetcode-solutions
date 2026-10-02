class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> have = new HashMap<>(); 

        for (char ch: text.toCharArray()) {
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> need = new HashMap<>(); 
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);
        
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