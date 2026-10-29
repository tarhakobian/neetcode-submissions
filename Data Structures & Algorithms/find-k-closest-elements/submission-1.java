class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> comparator = (a, b) -> {
            if (Math.abs(a - x) < Math.abs(b - x) ||
                (Math.abs(a - x) == Math.abs(b - x) && a < b)) {
                return 1;
            } else if (a.equals(b)) {
                return 0;
            } else {
                return -1;
            }
        };

        PriorityQueue<Integer> pr =
            new PriorityQueue<>(comparator);

        for (int n : arr) {
            pr.offer(n);

            if (pr.size() > k) {
                pr.poll();
            }
        }

        List<Integer> res = new ArrayList<>(pr);
        Collections.sort(res);

        return res;
    }
}