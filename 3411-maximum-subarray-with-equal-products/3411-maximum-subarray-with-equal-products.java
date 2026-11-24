class Solution {
    public int maxLength(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> factors = new HashSet<>();

            boolean duplicate = false;

            for (int j = i; j < n; j++) {

                int x = nums[j];

                // Find distinct prime factors
                for (int p = 2; (long) p * p <= x; p++) {

                    if (x % p == 0) {

                        // Prime already exists in another element
                        if (!factors.add(p)) {
                            duplicate = true;
                        }

                        // Remove all occurrences of this prime
                        while (x % p == 0) {
                            x /= p;
                        }
                    }
                }

                // Remaining prime factor
                if (x > 1) {
                    if (!factors.add(x)) {
                        duplicate = true;
                    }
                }

                int len = j - i + 1;

                // Single element: only [1] is valid
                if (len == 1) {
                    if (nums[i] == 1) {
                        maxLen = Math.max(maxLen, 1);
                    }
                }

                // Every subarray of length 2 is valid
                else if (len == 2) {
                    maxLen = Math.max(maxLen, 2);
                }

                // Length >= 3: all elements must be pairwise coprime
                else {

                    if (duplicate) {
                        break;
                    }

                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}