class Solution {
    public int longestOnes(int[] nums, int k) {
        int flipped = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flipped++;
            }

            while (flipped > k) {
                if (nums[left] == 0) {
                    flipped--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}