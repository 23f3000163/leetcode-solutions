class Solution {
    static boolean isValidAnswer(int[] arr, int m, int maxheight) {
        Arrays.sort(arr);
        
      //first cow is placed at 0 index
        long woodCollected = 0;
        
        for(int i = 0; i < arr.length;i++) {
            if(arr[i] > maxheight) {
                long currentTreeWoodCollected = arr[i] - maxheight;
                woodCollected += currentTreeWoodCollected;
            }
        }
        if(woodCollected >= m) {
            return true;
        } else {
            return false;
        }
        
    }    
    int maxHeight(int[] arr, int m) {
        
        // code here
        int n = arr.length;
        int s = 0;
        int ans = -1;
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] > ans) {
                sum += arr[i];
            }
        }
        
        int e = sum;
        
        while(s <= e) {
            
            int mid = s + (e - s) / 2;
            
            if(isValidAnswer(arr,m,mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
