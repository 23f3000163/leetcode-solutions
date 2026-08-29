class Solution {
    public int fib(int n) {
           // base condition
        if (n < 2) {
            return n;
        }
        //
        return fib(n - 1) + fib(n - 2);
    }
}