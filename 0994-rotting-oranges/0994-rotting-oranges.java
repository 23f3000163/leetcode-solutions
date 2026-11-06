class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean isValid(int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }
        return true;
    }


    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();

            while (size-- > 0) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int k = 0; k < 4; k++) {
                    int newRow = row + dx[k];
                    int newCol = col + dy[k];

                    if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }
}