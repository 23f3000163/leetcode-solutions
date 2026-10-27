class Solution {
    public String[] createGrid(int m, int n) {
        String topRow = ".".repeat(n);
        String remaining = "#".repeat(n - 1) + ".";

        String[] result = new String[m];
        result[0] = topRow;

        for (int i = 1; i < m; i++) {
            result[i] = remaining;
        }

        return result;
    }
}