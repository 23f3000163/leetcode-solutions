class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noPower = arr[0]; // Best sum without deletion
        int powerUse = 0;   // Best sum with one deletion
        int result = noPower; // Overall maximum

        for (int i = 1; i < n; i++) {
            int v1 = arr[i];
            int v2 = noPower + arr[i];
            int v3 = powerUse + arr[i]; 
            int v4 = noPower;
 
            noPower = Math.max(v1, v2); // Best without deletion
            powerUse = Math.max(v3, v4);  // Best with one deletion

            result = Math.max(result, Math.max(noPower, powerUse));
        }
        return result;
    }
}