class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean isValid(int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }
        return true;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col, int n, int m) {
        visited[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];

            if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(grid, visited, newRow, newCol, n, m);
            }
        }
        return;
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m =  grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}