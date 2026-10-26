class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int maxLength = 0;
        for(int n : nums){
            if(!set.contains(n - 1)){
                int length = 1;
                int curr = n;
                while(set.contains(curr + 1)){
                    curr++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
