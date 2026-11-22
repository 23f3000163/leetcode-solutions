class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = Arrays.copyOf(result, result.length);
            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];
                
                if (result[s] != Integer.MAX_VALUE && temp[d] > result[s] + wt) {
                    temp[d] = result[s] + wt;
                }
            }
            result = temp;
        }
        if (result[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return result[dst];
    }
}