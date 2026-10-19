class Solution {

    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
}
    
    public String reorganizeString(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
         //creating max heap for painrs
        PriorityQueue<Pair> pq = new PriorityQueue<>(
           (a, b) -> {
            return b.freq - a.freq;
           } 
        );

        // Step 3: Process distinct words
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            
            Pair curr = new Pair(ch, freq);

            pq.offer(new Pair(ch, map.get(ch)));
        }    
        int seat = 0;
        while(!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if (seat == 0 || result.charAt(seat - 1) != p1.ch) {
                result.append(p1.ch);
                seat++;
                p1.freq--;
            
                if(p1.freq > 0) {
                    pq.offer(p1);
                }
            }
            else {
                if (pq.isEmpty()) {
                    return "";
                }
                Pair p2 = pq.poll();

                result.append(p2.ch); 
                seat++;
                p2.freq--;

                if (p2.freq > 0) {
                    pq.offer(p2);
                }   
                pq.offer(p1);
            }
        }
        return result.toString();
    }
}