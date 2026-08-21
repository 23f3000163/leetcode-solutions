class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int m = 1;
        int o = 1;

        for(int i = 2; i < n; i++) {
            if(arr1[m - 1] > arr2[o - 1]) {
                arr1[m] = nums[i];
                m++;
            }

            else {
                arr2[o] = nums[i];
                o++;
            }
        }

        int[] result = new int[m + o];

        for(int j = 0; j < m; j++) {
            result[j] = arr1[j];
        }

        for(int k = 0; k < o; k++) {
            result[m + k] = arr2[k];
        }
        return result;
    }
}