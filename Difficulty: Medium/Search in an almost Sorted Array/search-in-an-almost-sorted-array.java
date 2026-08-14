class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        
        while(s <= e) {
            int mid = e - (e - s) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } 
            if (mid + 1 < n && arr[mid + 1] == target) {
                return mid + 1;
            }
            if(mid - 1 >= 0 && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (target > arr[mid]) {
                s = mid + 2;
            }
            else{
                e = mid - 2;
            }
        }    
        return -1;
    }
}