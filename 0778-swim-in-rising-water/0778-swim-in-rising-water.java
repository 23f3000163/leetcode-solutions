class Solution {

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int effort = current[0];
            int row = current[1];
            int col = current[2];

            if (effort > dist[row][col]) {
                continue;
            }

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int k = 0; k < 4; k++) {
                int r = row + dx[k];
                int c = col + dy[k];

                if (!isValid(r, c, n, m)) {
                    continue;
                }
                int Diff = grid[r][c];
                int newEffort = Math.max(effort, Diff);

                if (newEffort < dist[r][c]) {
                    dist[r][c] = newEffort;
                    pq.offer(new int[]{newEffort, r, c});
                }
            }
        }
        return 0;
    }
}