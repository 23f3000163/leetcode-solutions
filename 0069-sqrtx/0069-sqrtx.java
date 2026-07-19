class Solution {
    public int mySqrt(int x) {
        

        int s = 1;
        int e = x;
        int squareRoot = -1;

        if (x == 0) {
            return 0;
        }

        while (s <= e) {

            int m = s + (e - s) / 2;

            if(m == x / m) {
                return m;
            }

            else if (m > x / m) {
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