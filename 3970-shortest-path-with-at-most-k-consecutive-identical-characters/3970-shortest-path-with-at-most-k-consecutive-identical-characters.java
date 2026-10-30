class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Each state is {cost, node, consecutiveCount}
        PriorityQueue<int[]> queue =
                new PriorityQueue<>(Comparator.comparingInt(state -> state[0]));

        dist[0][1] = 0;
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int cost = state[0];
            int node = state[1];
            int count = state[2];

            if (cost != dist[node][count]) continue;
            if (node == n - 1) return cost;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int nextCost = cost + edge[1];

                int nextCount = labels.charAt(next) == labels.charAt(node)
                        ? count + 1
                        : 1;

                if (nextCount <= k && nextCost < dist[next][nextCount]) {
                    dist[next][nextCount] = nextCost;
                    queue.offer(new int[]{nextCost, next, nextCount});
                }
            }
        }

        return -1;
    }
}