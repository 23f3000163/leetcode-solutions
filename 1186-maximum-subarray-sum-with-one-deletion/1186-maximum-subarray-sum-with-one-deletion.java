class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noPower = arr[0];
        int powerUse = 0;
        int result = noPower;

        for (int i = 1; i < n; i++) {
            int v1 = arr[i];
            int v2 = noPower + arr[i];
            int v3 = powerUse + arr[i]; 
            int v4 = noPower;

            result = Math.max(result, Math.max(Math.max(v1, v2), Math.max(v3, v4)));

            noPower = Math.max(v1, v2);
            powerUse = Math.max(v3, v4); 
        }
        
        return result;
    }
}