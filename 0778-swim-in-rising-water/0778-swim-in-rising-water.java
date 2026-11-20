class Solution {

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private boolean bfs(int[][] grid, int n, int m, int mid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n ; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<int []> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0]; 
            int col = current[1];

            if (row == n - 1 && col == m - 1) {
                return true;
            }

            for (int j = 0; j < 4; j++) {
                int newRow = row + dx[j]; 
                int newCol = col + dy[j];

                if (isValid(newRow, newCol, n, m) && visited[newRow][newCol] == false && mid >= grid[newRow][newCol]) {
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int low = grid[0][0];
        int high = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                high = Math.max(high, grid[i][j]);
            }
        }

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (bfs(grid, n, m, mid)) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }
}