class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int maxLength = 0;
        for(int n : set){
            if(set.contains(n - 1)){
                continue;
            }

            int size = 1;
            while(set.contains(n + 1)){
                size++;
                n++;
            }
            maxLength = Math.max(maxLength, size);
        }
        
        return maxLength;
    }
}
