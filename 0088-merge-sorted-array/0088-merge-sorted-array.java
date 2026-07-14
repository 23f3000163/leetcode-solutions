class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged[] = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        while(i < m) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while(j < n) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        for (int x = 0;x < n + m; x++) {
            nums1[x] = merged[x];
        }
    }
}