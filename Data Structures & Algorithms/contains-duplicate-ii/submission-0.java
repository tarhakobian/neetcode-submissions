class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> arr = map.get(nums[i]);
                for(int idx : arr){
                    if(Math.abs(i - idx) <= k) return true;
                }

                arr.add(i);
            }else{
                map.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }

        return false;
    }
}