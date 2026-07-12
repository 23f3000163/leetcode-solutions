class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        if (mat == null || mat.length == 0) {
            return;
        }

        int m = mat.length;;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            int top = 0;
            int bottom = m - 1;

            while (top < bottom) {
                 int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;

                top++;
                bottom--;
            }
        }
    }
}