class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int n = row * col;
        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[index] = matrix[i][j];
                index++;
            }
        }

        Arrays.sort(ans);
        int s = 0;
        int e = n - 1;
        int target = k - 1;
        int answer = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid == target) {
                answer = ans[mid];
                e = mid - 1;
            }
            else if (mid < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        } 
        return answer;
    }
}