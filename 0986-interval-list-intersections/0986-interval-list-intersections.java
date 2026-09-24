class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        int[][] ans = new int[n + m][];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < n && j < m) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if (start1 <= start2) {
                if (end1 >= start2) {
                    int startIntersection = Math.max(start1, start2);
                    int endIntersection = Math.min(end1, end2);
                    ans[index] = new int[]{startIntersection, endIntersection};
                    index++;
                }
            }
            else {
                if (end2 >= start1) {
                    int startIntersection = Math.max(start1, start2);
                    int endIntersection = Math.min(end1, end2);
                    ans[index] = new int[]{startIntersection, endIntersection};
                    index++;
                }
            }
            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        } 
        return Arrays.copyOf(ans, index);
    }
}