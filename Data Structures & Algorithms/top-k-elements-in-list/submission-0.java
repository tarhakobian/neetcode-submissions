class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            q.offer(new int[]{e.getValue(), e.getKey()});
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = q.poll()[1];
        }

        return res;
    }
}
