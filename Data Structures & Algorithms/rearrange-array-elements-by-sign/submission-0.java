class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayDeque<Integer> posQ = new ArrayDeque<>();
        ArrayDeque<Integer> negQ = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                posQ.offer(nums[i]);
            } else {
                negQ.offer(nums[i]);
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[i * 2] = posQ.poll();
            nums[i * 2 + 1] = negQ.poll();
        }

        return nums;
    }
}