class Solution {
    // static int getFirstOccIndex(int[][] arr, int rowIndex) {
    //     int rowTotals = arr.length;
    //     int colTotals = arr[0].length;
    //     int target = 1;
    //     int ans = -1;

    //     if(arr[rowIndex][colTotals - 1] == 0) {
    //         return colTotals;
    //     }
    //     else {
    //         int s = 0;
    //         int e = colTotals - 1;
    //         while(s <= e) {
    //             int mid = s + (e - s) / 2;
    //             if(arr[rowIndex][mid] == 0) {
    //                 s = mid + 1;
    //             }

    //             else {
    //                 ans = mid;
    //                 e = mid - 1;
    //             } 
    //         }
    //         return ans;
    //     }
    // }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowTotal = mat.length;
        int colTotal = mat[0].length;

        int max = 0;
        int maxOneWaliRowIndex = 0;

        for(int row = 0; row < rowTotal; row++) {

            int count = 0;

            for (int col = 0; col < colTotal; col++) {
                if (mat[row][col] == 1) {
                    count++;
                }
            }

            if(count > max) {
                max = count;
                maxOneWaliRowIndex = row;
            }

            // int firstOccIndex = getFirstOccIndex(mat, row);

            // int oneCount  = colTotal - firstOccIndex;

            // if(oneCount != 0 && oneCount > max) {
            //     max = oneCount;
            //     maxOneWaliRowIndex = row;
            // }
            
        }   
        int[] finalAns = {maxOneWaliRowIndex, max};
        return finalAns;
    }
}