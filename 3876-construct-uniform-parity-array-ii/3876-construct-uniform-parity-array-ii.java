class Solution {
    public boolean uniformArray(int[] nums1) {

        int smallestOdd = Integer.MAX_VALUE;
        int smallestEven = Integer.MAX_VALUE;

        for (int num : nums1) {

            if (num % 2 == 0) {
                smallestEven = Math.min(smallestEven, num);
            } else {
                smallestOdd = Math.min(smallestOdd, num);
            }
        }

        if (smallestOdd == Integer.MAX_VALUE) {
            return true;
        }

        if (smallestEven == Integer.MAX_VALUE) {
            return true;
        }
        
        return smallestOdd < smallestEven;
    }
}