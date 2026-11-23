class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{beginWord, "1"});
        set.remove(beginWord);

        while (!q.isEmpty()) {
            String[] current = q.poll();
            String word = current[0];
            int steps = Integer.parseInt(current[1]);
           
            if (word.equals(endWord)) {
                return steps;
            }
          
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
               
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) {
                        continue;
                    }
                    chars[i] = ch;
                    String newWord = new String(chars);

                  
                    if (set.contains(newWord)) {
                        q.offer(new String[]{
                            newWord,
                            String.valueOf(steps + 1)
                        });  
                        set.remove(newWord);
                    }
                }
             
                chars[i] = original;
            }
        }
        return 0;
   }

}