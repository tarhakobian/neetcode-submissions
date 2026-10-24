class Solution {
    public int majorityElement(int[] nums) {
        int treshold = nums.length / 2;
        System.out.println(treshold);
        Map<Integer, Integer> occ = new HashMap<>();

        for(Integer n : nums){
            if(occ.containsKey(n)){
                occ.put(n, occ.get(n) + 1);
            }else{
                occ.put(n, 1);
            }

            if(occ.get(n) > treshold) return n;
        }

        return -1;
    }
}