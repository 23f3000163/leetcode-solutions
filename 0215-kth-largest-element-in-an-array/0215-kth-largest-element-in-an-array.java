class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < n; i++) {
            if (nums[i] <= heap.peek()) {
                continue;
            }
            heap.poll();
            heap.offer(nums[i]);
        }
        return heap.peek();
    }
}