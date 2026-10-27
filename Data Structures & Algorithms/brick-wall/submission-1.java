class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gaps = new HashMap<>();
        int maxGaps = 0;
        for(List<Integer> row : wall){
            for(int i = 0, currEnd = 0; i < row.size() - 1; i++){
                currEnd += row.get(i);
                if(gaps.containsKey(currEnd)){
                    gaps.put(currEnd, gaps.get(currEnd) + 1);
                }else{
                    gaps.put(currEnd, 1);
                }
                maxGaps = Math.max(maxGaps, gaps.get(currEnd));
            }
        }
        return wall.size() - maxGaps;
    }
}