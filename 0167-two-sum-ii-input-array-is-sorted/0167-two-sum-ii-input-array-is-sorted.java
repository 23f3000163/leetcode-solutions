class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0;i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int ans[] = {i + 1, j + 1};
                    return ans;
                }
            }
        }
        int ans[]= { };
        return ans;
    }
}