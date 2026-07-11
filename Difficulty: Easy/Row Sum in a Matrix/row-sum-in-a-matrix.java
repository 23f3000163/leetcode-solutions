class Solution {
    public static int[] rowSum(int mat[][]) {
        // Code here
       
        int m = mat.length;;
        int n = mat[0].length;
        int [] result = new int [m];
        
        
        for (int row = 0; row < m; row++) {
            //when i  reach a new row i will set the sum = 0
            int sum = 0;
            for (int col = 0; col < n; col++) {
                int value =  mat[row][col];
                sum += value;
            }
            //after adding all the elements in the a columns add the sum to result
            result[row] = sum;
        }

        return result;
    }
}