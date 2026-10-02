class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> occ = new HashMap<>();
        for(Integer n : nums){
            if(occ.containsKey(n)){
               return true;
            }

            occ.put(n, 1);
        }

        return false;
    }
}