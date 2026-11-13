class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        } 

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();

            int t = current[0];
            int node = current[1];

            if (t > dist[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int wt = neighbor[1];

                if (t + wt < dist[nextNode]) {
                    dist[nextNode] = t + wt;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                } 
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}