class Solution {
    int floorSqrt(int n) {
        // code here
        int s = 1;
        int e = n;
        int squareRoot = -1;

        if (n == 0) {
            return 0;
        }

        while (s <= e) {

            int m = s + (e - s) / 2;

            if(m == n / m) {
                return m;
            }

            else if (m > n / m) {
                e = m - 1;
            } 

            else {
                squareRoot = m;
                s = m + 1;
            }
        }
        return squareRoot;
    }
}