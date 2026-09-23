class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] temp = new int[n + 1][];
        int[][] ans = new int[n + 1][];
        int index = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int newstart1 = newInterval[0];
        int newend1 = newInterval[1];

        boolean insert = false;
        for (int i = 0; i < n; i++) {
            if(insert == false && intervals[i][0] > newInterval[0]) {
                temp[index] = new int[]{newstart1, newend1};
                index++;
                insert = true;
            }
            temp[index] = Arrays.copyOf(intervals[i], intervals[i].length);
            index++;
        }
        if (insert == false) {
            temp[index] = new int[]{newstart1, newend1};
            index++;
        }

        int ansindex = 0;
        int start1 = temp[0][0];
        int end1 = temp[0][1];

        for (int i = 1;i < index; i++) {
        
            int start2 = temp[i][0];
            int end2 = temp[i][1];

            if (end1 >= start2) {
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
            else {
                ans[ansindex] = new int[]{start1, end1};
                ansindex++;
            }
            start1 = start2;
            end1 = end2;
        }
        ans[ansindex] = new int[]{start1, end1};
        ansindex++;

        return Arrays.copyOf(ans, ansindex); // it gives the copy of ans array from start to index so that the null values can be avoided
    }
}