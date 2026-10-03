class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int max = 0;
        for (int num : set) {
            // Only start counting if 'num' is the START of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // Count consecutive numbers going upwards
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }

                max = Math.max(max, currentLen);
            }
        }

        return max;
    }
}
