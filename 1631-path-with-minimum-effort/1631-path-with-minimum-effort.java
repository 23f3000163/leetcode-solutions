
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        // Store minimum effort required to reach each cell
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        // PriorityQueue: {effort, {row, col}}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        // Direction arrays: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Starting cell
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int effort = p[0];
            int row = p[1];
            int col = p[2];

            // Skip outdated entries
            if (effort > dist[row][col]) {
                continue;
            }
            // Destination reached
            if (row == n - 1 && col == m - 1) {
                return effort;
            }
            // Explore 4 directions
            for (int k = 0; k < 4; k++) {
                int r = row + dx[k];
                int c = col + dy[k];
                if (!isValid(r, c, n, m)) {
                    continue;
                }
                // Difference between adjacent cells
                int absDiff = Math.abs(
                    heights[row][col] - heights[r][c]
                );
                // Maximum effort along this path
                int newEffort = Math.max(effort, absDiff);

                // Relaxation
                if (newEffort < dist[r][c]) {
                    dist[r][c] = newEffort;
                    pq.offer(new int[]{newEffort, r, c});
                }
            }
        }
        return 0;
    }

    // Check whether cell is inside the grid
    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
