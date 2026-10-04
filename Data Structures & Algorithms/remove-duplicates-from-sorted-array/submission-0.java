class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        Set<Integer> seen = new HashSet<>();

        while(left < nums.length){
            if(!seen.contains(nums[left])){
                seen.add(nums[left]);
            }else{
                int right = left + 1;
                while(right < nums.length){
                    if(!seen.contains(nums[right])){
                        nums[left] = nums[right];
                        seen.add(nums[left]);
                        break;
                    }

                    right++;
                }
            }

            left++;
        }

        return seen.size();
    }
}