class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);
        long total = 0;

        if ((long) cost1 + cost2 <= costBoth) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        }
        
        total = costBoth * common;
        need1 -= common;
        need2 -= common;

        if (need1 > 0) {
            total += need1 * Math.min((long) cost1, (long) costBoth);
        }
        else if (need2 > 0) {
            total += need2 * Math.min((long) cost2, (long) costBoth);
        }        
        return total;
    }
}