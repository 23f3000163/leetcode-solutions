class Solution {
    public int commonFactors(int a, int b) {
        int common = 0;

        int big = Math.max(a, b);

        for (int i = 1; i < big + 1; i ++) {
            if (a % i == 0 && b % i == 0) {
                common++;
            }
        }
        return common;
    }
}