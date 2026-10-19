class Solution {
    class Pair {
        int[] point;
        int distance;

        Pair(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] ans = new int[k][2];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.distance - a.distance
        );

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            Pair curr = new Pair(point, distance); 

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }
             // Replace root only if current point is closer
            if (curr.distance < pq.peek().distance) {
                pq.poll();
                pq.offer(curr);
            }
        }

        int index = 0;

        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().point;
        }
        return ans;
    }
}