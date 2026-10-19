class Solution {
    class Pair {
        String word;
        int frequency;

        Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        
        //storing words and its frequency
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //creating min heap for painrs
    
        PriorityQueue<Pair> pq = new PriorityQueue<>(
           (a, b) -> {
            if (a.frequency != b.frequency) {
                return a.frequency - b.frequency; 
            }
            return b.word.compareTo(a.word);
           } 
        );

        // Step 3: Process distinct words
        for (String word : map.keySet()) {
            int freq = map.get(word);
            
            Pair curr = new Pair(word, freq);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }
             // Skip if the current word is less desirable
            if (curr.frequency < pq.peek().frequency ||
                (curr.frequency == pq.peek().frequency &&
                 curr.word.compareTo(pq.peek().word) > 0)) {
                continue;
            }
            // Replace the least desirable word
            pq.poll();
            pq.offer(curr);
        }
        // Step 4: Extract words
        int index = 0;
        while (!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }
         // Step 5: Reverse to get the required order
        Collections.reverse(ans);
        return ans;
    }
}