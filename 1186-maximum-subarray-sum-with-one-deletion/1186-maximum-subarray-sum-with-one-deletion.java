class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDelete = arr[0];
        int oneDelete = 0;
        int result = noDelete;

        for (int i = 1; i < n; i++) {
            int prevNodelete = noDelete;
            int prevOnedelete = oneDelete;

            noDelete = Math.max(arr[i] , arr[i] + prevNodelete);

            oneDelete = Math.max(prevOnedelete + arr[i], prevNodelete);
            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        
        return result;
    }
}