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

        // If there are no odd numbers, all numbers are already even.
        if (smallestOdd == Integer.MAX_VALUE) {
            return true;
        }

        // If there are no even numbers, all numbers are already odd.
        if (smallestEven == Integer.MAX_VALUE) {
            return true;
        }

        // Mixed parity:
        // We can make every even number odd only if
        // there is an odd number smaller than every even number.
        return smallestOdd < smallestEven;
    }
}