class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int startingRow = 0;
        int endingRow = m - 1;

        int startingColumn = 0;
        int endingColumn = n - 1;

        while (startingRow <= endingRow && startingColumn <= endingColumn) {
            // rowwise left to right -> starting row print krni hai from starting col to ending col
            for (int col = startingColumn; col <= endingColumn; col++) {
                result.add(matrix[startingRow][col]);
            }
            startingRow++;
            // colwise top to bottom -> ending col print krni hai from starting row to ending row
            for (int row = startingRow; row <= endingRow; row++) {
                result.add(matrix[row][endingColumn]);
            }
            endingColumn--;
            //rowwise right to left -> ending row print krni hai from ending col to starting col
            //valid ending row -> starting row <= ending row
            if (startingRow <= endingRow) {
                for (int col = endingColumn; col >= startingColumn; col--) {
                    result.add(matrix[endingRow][col]);
                }
                endingRow--;
            }
            //colwise bottom to top -> starting col print krni hai form ending row to starting row
            //valid starting col -> starting col <= ending col
            if (startingColumn <= endingColumn) {
                for (int row = endingRow; row >= startingRow; row--) {
                    result.add(matrix[row][startingColumn]);
                }
                startingColumn++;
            }
        }
        return result;
    }
}