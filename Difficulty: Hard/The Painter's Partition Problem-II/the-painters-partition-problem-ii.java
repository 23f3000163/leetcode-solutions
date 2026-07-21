class Solution {
    
    static boolean isValidAnswer(int[] arr, int k, int maxPaint) {
        int painterCount = 1;
        int paints = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > maxPaint) {
                return false;
            }
            if(paints + arr[i] <= maxPaint) {
                paints += arr[i];
            } else {
                painterCount++;
                paints = 0;
                paints = paints + arr[i];
                
                if(painterCount > k) {
                    return false;
                }
            }   
        }
        return true;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        int n = arr.length;
        int s = 0;
        int ans = -1;
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        int e = sum;
        
        while(s <= e) {
            
            int m = s + (e - s) / 2;
            
            if(isValidAnswer(arr,k,m)) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}
