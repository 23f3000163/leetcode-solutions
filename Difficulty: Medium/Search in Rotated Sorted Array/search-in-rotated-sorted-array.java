class Solution {
    int search(int[] arr, int key) {
        // code here
               int pivot = findPivot(arr);

        // if you did not find a pivot ,it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(arr,key,0, arr.length - 1);
        }
        // if pivot is found ,you  have found 2 asc sorted arrays
        if (arr[pivot] == key) {
            return pivot;
        }

        if (key >= arr[0]) {
            return binarySearch(arr, key,0,pivot - 1);
        }
        return binarySearch(arr,key,pivot + 1,arr.length - 1);
    }

    public static int binarySearch(int[] arr, int key, int start,int end) {

        while (start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                // answer found
                return mid;
            }
        }

        return -1; // target not found
    }


    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}