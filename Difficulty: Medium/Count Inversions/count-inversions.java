class Solution {
    
    static int merge(int[] arr, int s, int e, int mid) {
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
            int inversionCount = 0;
            
            while (i < leftArrLength && j < rigthArrLength) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k] = leftArr[i];
                    i++;
                    k++;
                }
                else {
                    
                    arr[k] = rightArr[j];
                    j++;
                    k++;
                    
                    inversionCount = inversionCount + (leftArrLength - i);
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
            return inversionCount;
        }
        
    static int mergeSort(int[] arr, int s, int e) {
        if (s >= e) {
            return 0;
        }
        
        int mid = s + (e - s) / 2;
        
        int leftInversions = mergeSort(arr, s, mid);
        int rightInversions = mergeSort(arr, mid + 1, e);
        int intermediateInversions = merge(arr, s, e, mid);
        
        int invCount = leftInversions + rightInversions + intermediateInversions;
        return invCount;
    }
    public int inversionCount(int arr[]) {
        // code here
        int s = 0;
        int e = arr.length - 1;
        int ans = mergeSort(arr, s, e);
        return ans;
    }
}