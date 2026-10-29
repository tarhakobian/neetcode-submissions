class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int maxLength = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            max = Math.max(nums[right], max);
            min = Math.min(nums[right], min);

            long absDiff = (long) max - min;

            while (absDiff > limit) {
                left++;

                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;

                for (int i = left; i <= right; i++) {
                    max = Math.max(nums[i], max);
                    min = Math.min(nums[i], min);
                }

                absDiff = (long) max - min;
            }

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}