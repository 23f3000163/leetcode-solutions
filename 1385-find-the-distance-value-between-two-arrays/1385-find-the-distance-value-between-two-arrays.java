class Solution {

    public boolean fun(int num, int[] arr, int diff) {
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(num - arr[i]) <= diff) {
                return false;
            }
        }
        return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if(fun(arr1[i], arr2, d)) {
                count++;
                i++;
                j = 0;
            }
            else {
                i++;
                j = 0;
            }
        }
        return count;    
    }
}