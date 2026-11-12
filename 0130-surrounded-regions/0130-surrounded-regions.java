class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean isValid(int row, int col, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }
        return true;
    }

    public void dfs(char[][] board, int i, int j, int n, int m) {
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int newRow = i + dx[k];
            int newCol = j + dy[k];

            if (isValid(newRow, newCol, n, m) && board[newRow][newCol] == 'O') {
                dfs(board, newRow, newCol, n, m);
            }
        }    
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

         // 1. First row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, n, m);
        }

        // 2. First column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, n, m);
        }

        // 3. Last row
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O')
                dfs(board, n - 1, j, n, m);
        }

        // 4. Last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1, n, m);
        }

        // 5. Replace remaining O with X
        //    Replace # back with O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }        
            }
        }

    }
}