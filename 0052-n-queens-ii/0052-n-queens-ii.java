class Solution {

    static boolean isSafeToPlace(int colIndex, int rowIndex, char[][] chessboard , int n) {
        int row = rowIndex;
        int col = colIndex;

        while (col >= 0) {
            if(chessboard[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = rowIndex;
        col = colIndex;

        while (col >= 0 && row >= 0) {
            if(chessboard[row][col] == 'Q') {
                return false;
            }
            row = row - 1;
            col = col - 1;
        }

        row = rowIndex;
        col = colIndex;

        while (col >= 0 && row < n) {
            if(chessboard[row][col] == 'Q') {
                return false;
            }
            row = row + 1;
            col = col - 1;
        }
        return true;
    }

    static void solve(int n, char[][] chessboard, int colIndex, List<List<String>> ans){
        if(colIndex >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(chessboard[i]));
            }
            ans.add(temp);
            return;
        }
        
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if(isSafeToPlace(colIndex, rowIndex, chessboard, n)) {
                chessboard[rowIndex][colIndex] = 'Q';
                solve(n, chessboard, colIndex + 1, ans);
                //BACKTRACK
                chessboard[rowIndex][colIndex] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(chessboard[i], '.');
        }

        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();
       
        solve(n, chessboard, colIndex, ans);
        
        return ans.size();
    }
}