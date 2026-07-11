class Solution {
    public int[][] transpose(int[][] matrix) {
         if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        //for old array
        int rows = matrix.length;;
        int cols = matrix[0].length;
        //for new array
        int newrows = cols;
        int newcols = rows;
        int[][] arr = new int[newrows][newcols];
        
        //actual logic
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[j][i] = matrix[i][j];
            }
        }
        return arr;
    }
}