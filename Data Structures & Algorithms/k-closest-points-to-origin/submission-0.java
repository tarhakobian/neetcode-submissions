class Solution {
    private double getDistFromOrigin(int[] point) {
        return Math.sqrt(
            point[0] * point[0] + point[1] * point[1]
        );
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                getDistFromOrigin(a),
                getDistFromOrigin(b)
            )
        );

        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}