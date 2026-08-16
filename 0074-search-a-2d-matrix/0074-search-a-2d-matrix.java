class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int n = row * col;
        int s = 0;
        int e = n - 1;

        while(s <= e) {
            int m = s + (e - s) / 2;
            int rowIndex = m / col;
            int colIndex = m % col;

            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }

            if (matrix[rowIndex][colIndex] > target) {
                e = m - 1;
            }

            else {
                s = m + 1;
            }
        }
        return false;
    }
}