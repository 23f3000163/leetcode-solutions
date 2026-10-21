class Solution {

    class Pair {
        char ch;
        int freq;

        Pair(int freq, char ch) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        HashMap<Character, Integer> map = new HashMap<>();
         HashMap<Character, Integer> free = new HashMap<>();
        
        
        for (int i = 0; i < m; i++) {
            char ch = tasks[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            free.put(ch, 1);
        }

        //creating max heap for painrs
        PriorityQueue<Pair> pq = new PriorityQueue<>(
           (a, b) -> {
            return b.freq - a.freq;
           } 
        );

        // Step 3: Process distinct words
        for (char ch : map.keySet()) {
            pq.offer(new Pair( map.get(ch), ch));
        }    

        
        int seat = 1;
        while (!pq.isEmpty()) {
            Pair[] pulled = new Pair[pq.size()];
            int idx = 0;
            //boolean executed = false;
            while (!pq.isEmpty()) {
                Pair p = pq.peek();
                pq.poll();
                int freq = p.freq;
                char ch = p.ch;

                if (free.get(ch) <= seat) {
                    if (p.freq > 1) {
                        pq.offer(new Pair(p.freq - 1, ch));
                    }
                    free.put(ch, seat + n + 1);
                    //executed = true;
                    break;
                }
                else {
                    pulled[idx++] = p;
                }
            }
            for (int i = 0; i < idx; i++) {
                pq.offer(pulled[i]);
            }
            seat++;
       }
       return seat - 1;
    }
}