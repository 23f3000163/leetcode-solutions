class Solution {

    static int first(int[] nums, int target, int s, int e, int first) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > target) {
                e = mid - 1;
            }
            else if (nums[mid] < target) {
                s = mid + 1;
            }
            else {
                first = mid;
                e = mid - 1;
            }
        }
        return first;
    }

    static int last(int[] nums, int target, int s, int e, int last) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > target) {
                e = mid - 1;
            }
            else if (nums[mid] < target) {
                s = mid + 1;
            }
            else {
                last = mid;
                s = mid + 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int first = -1;
        int last = -1;

        //FOR FIRST
        first = first(nums, target, s, e, first);
        //FOR LAST
        last = last(nums, target, s, e, last);


        int[] ans = {first, last};
        return ans;
    }
}