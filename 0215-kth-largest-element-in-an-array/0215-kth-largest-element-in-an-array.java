class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < n; i++) {
            if (nums[i] <= minHeap.peek()) {
                continue;
            }
            minHeap.poll();
            minHeap.offer(nums[i]);
        }
        return minHeap.peek();
    }
}