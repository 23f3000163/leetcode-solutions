class Solution {

    public int find(int[] arr) {
        int max = -1;
        for (int i = 0; i < 256; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        
        int low = 0;
        int high = 0;
        int maxLength = Integer.MIN_VALUE;

        int[] letters = new int[256];

        for (high = 0; high < n; high++) {
            letters[s.charAt(high)]++;

            int length = high - low + 1;
            int maxCount = find(letters);
            int diff = length - maxCount;

            while (diff > k) {
                letters[s.charAt(low)]--;
                low++;

                maxCount = find(letters);
                length = high - low + 1;
                diff = length - maxCount;
            }
            length = high - low + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}