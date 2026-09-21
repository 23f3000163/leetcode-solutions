class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] ans = new int[n][];
        int index = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1;i < n; i++) {
        
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
            else {
                ans[index] = new int[]{start1, end1};
                index++;
            }
            start1 = start2;
            end1 = end2;
        }
        ans[index] = new int[]{start1, end1};
        index++;

        return Arrays.copyOf(ans, index); // it gives the copy of ans array from start to index so that the null values can be avoided
    }
}