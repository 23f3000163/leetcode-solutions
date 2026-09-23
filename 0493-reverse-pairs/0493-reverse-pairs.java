class Solution {
    static int merge(int[] nums, int s, int e, int mid) {
            int leftArrLength = mid - s + 1;
            int rigthArrLength = e - mid;

            int[] leftArr = new int[leftArrLength];
            int[] rightArr = new int[rigthArrLength];

            int k = s;
            for (int i = 0; i < leftArrLength; i++) {
                leftArr[i] = nums[k];
                k++;
            }
            k = mid + 1;
            for (int j = 0; j < rigthArrLength; j++) {
                rightArr[j] = nums[k];
                k++;
            }
            //count resverse pain
            int reversePairCount = 0;
            int j = 0;
            for (int i = 0; i < leftArrLength; i++) {
                while (j < rigthArrLength && (long)leftArr[i] > 2L * rightArr[j]) {
                    j++;
                }
                reversePairCount += j;
            }

            //Merge the arrays
            int i = 0;
            j = 0;
            k = s;
            
            
            while (i < leftArrLength && j < rigthArrLength) {
                if (leftArr[i] <= rightArr[j]) {
                    nums[k] = leftArr[i];
                    i++;
                    k++;
                }
                else {
                    nums[k] = rightArr[j];
                    j++;
                    k++;
                }
            }
            while (i < leftArrLength) {
                nums[k] = leftArr[i];
                i++;
                k++;
            }
            while (j < rigthArrLength) {
                nums[k] = rightArr[j];
                j++;
                k++;
            }
            return reversePairCount;
        }
        
    static int mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        
        int mid = s + (e - s) / 2;
        
        int leftInversions = mergeSort(nums, s, mid);
        int rightInversions = mergeSort(nums, mid + 1, e);
        int intermediateInversions = merge(nums, s, e, mid);
        
        int invCount = leftInversions + rightInversions + intermediateInversions;
        return invCount;
    }

    public int reversePairs(int[] nums) {

        int s = 0;
        int e = nums.length - 1;
        int ans = mergeSort(nums, s, e);
        return ans;
        
    }
}