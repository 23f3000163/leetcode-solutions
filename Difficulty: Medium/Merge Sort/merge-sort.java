class Solution {
    
    static void merge(int[] arr, int s, int e, int mid) {
        int leftArrLength = mid - s + 1;
        int rigthArrLength = e - mid;
        
        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rigthArrLength];
        
        int k = s;
        for (int i = 0; i < leftArrLength; i++) {
            leftArr[i] = arr[k];
            k++;
        }
        k = mid + 1;
        for (int j = 0; j < rigthArrLength; j++) {
            rightArr[j] = arr[k];
            k++;
        }
        
        //Merge the arrays
        int i = 0;
        int j = 0;
        k = s;
        while (i < leftArrLength && j < rigthArrLength) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
        while (i < leftArrLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rigthArrLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    public void mergeSort(int arr[], int l, int r) {
        // code here
        int s = l;
        int e = r;
        
        if (s >= e) {
            return;
        }
        
        int mid = (s + e) / 2;
        
        
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e, mid);
    }
}