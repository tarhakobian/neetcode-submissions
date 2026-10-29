class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> occ = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue((a, b) -> occ.get(b) - occ.get(a));

        for(Character c : s.toCharArray()){
            occ.put(c, occ.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> e : occ.entrySet()){
            Character c = e.getKey();
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character nextC = pq.poll();
            int times = occ.get(nextC);

            for(int i = 0; i < times; i++){
                sb.append(nextC);
            }
        }

        return sb.toString();
    }
}