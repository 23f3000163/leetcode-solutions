class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] choices = new int[n][2];

        for (int i = 0; i < n; i++) {
            choices[i][0] = capital[i];
            choices[i][1] = profits[i];
        }

        Arrays.sort(choices, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 

        int idx = 0;
        while (k-- > 0) {
            while (idx < n) {
                if(choices[idx][0] > w) {
                    break;
                }
                pq.offer(choices[idx][1]);
                idx++;
            }
            
            if (pq.isEmpty()) {
            return w;
            }

            w = w + pq.peek();
            pq.poll();
        }
        return w;
    }
}