class Solution {

    static void merge(int[] nums, int start, int end, int mid) {
        int leftArrLen = mid - start + 1;
        int rightArrLen = end - mid;

        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        int k = start;
        for (int i = 0; i < leftArrLen; i++) {
            leftArr[i] = nums[k];
            k++;
        }

        k = mid + 1;
        for (int j = 0; j < rightArrLen; j++) {
            rightArr[j] = nums[k];
            k++;
        }

        int i = 0;
        int j = 0;
        k = start;

        while (i < leftArrLen && j < rightArrLen) {
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
        while (i < leftArrLen) {
            nums[k] = leftArr[i];
                i++;
                k++;
        }
        while (j < rightArrLen) {
            nums[k] = rightArr[j];
                j++;
                k++;
        }
    }

    public void mergeSort(int[] nums, int start, int end){
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, end, mid);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}