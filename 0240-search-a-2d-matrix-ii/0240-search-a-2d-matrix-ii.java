class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int rowIndex = row - 1;
        int colIndex = 0;

        while (rowIndex >= 0 && colIndex < col) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }
            if (matrix[rowIndex][colIndex] > target) {
                rowIndex--;
            }
            else if (matrix[rowIndex][colIndex] < target) {
                colIndex++;
            }
        }
        return false;
    }
}