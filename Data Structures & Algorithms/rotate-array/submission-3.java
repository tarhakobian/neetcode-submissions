class Solution {
    public void rotate(int[] nums, int k) {
        int effectiveK = k % nums.length;

        for(int i = 0; i < k; i++){
            int tempLast = nums[nums.length - 1];
            for(int idx = nums.length - 1; idx > 0; idx--){
                nums[idx] = nums[idx - 1];
            }
            nums[0] = tempLast;
        }
    }
}