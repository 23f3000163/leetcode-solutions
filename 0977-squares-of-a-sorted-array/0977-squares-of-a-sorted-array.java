class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
       
        int a[] = new int[n];
        int b[] = new int[n];

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i]  >= 0) {
                a[aCount] = nums[i];
                aCount++;
            } else {
                b[bCount] = nums[i];
                bCount++;
            }
        }

        if (aCount == 0) {
            for (int i = 0; i < bCount; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        } 

        if (bCount == 0) {
            for (int i = 0; i < aCount; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        } 

        for (int i = 0; i < aCount; i++) {
            a[i] = a[i] * a[i];
        }

        for (int i = 0; i < bCount; i++) {
            b[i] = b[i] * b[i];
        }
        Arrays.sort(b, 0, bCount);
    
    
        int sortedsquare[] = new int[n];

        int i = 0;
        int j = 0;
        int id = 0;

        while(i < aCount && j < bCount) {
            if (a[i] <= b[j]) {
                sortedsquare[id] = a[i];
                id++;
                i++;
            } else {
                sortedsquare[id] = b[j];
                id++;
                j++;
            }
        }
        while (i < aCount) {
            sortedsquare[id] = a[i];
                id++;
                i++;
        }

        while (j < bCount) {
            sortedsquare[id] = b[j];
                id++;
                j++;
        }
        return sortedsquare;
    }    
}