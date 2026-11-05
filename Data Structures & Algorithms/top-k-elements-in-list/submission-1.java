class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occ = new HashMap<>();
        for(int n : nums){
            occ.put(n, occ.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(occ.get(a), occ.get(b))
        );
        for(Integer n : occ.keySet()){
            q.offer(n);

            if(q.size() > k){
                q.poll();
            }
        }

        return q.stream().mapToInt(i -> i).toArray();
    }
}
