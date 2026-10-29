class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);  // Fixed
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}