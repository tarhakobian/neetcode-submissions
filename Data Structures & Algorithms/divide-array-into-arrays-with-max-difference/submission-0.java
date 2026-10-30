class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int groups = nums.length / 3;
        int[][] res = new int[groups][3];
        for(int group = 0; group < groups; group++){
            int startIdx = group * 3;
            int endIdx = startIdx + 2;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = startIdx; j <= endIdx; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
            int diff = max - min;
            if(diff > k){
                return new int[0][0];
            }else{
                int[] g = new int[3];
                for(int j = startIdx; j <= endIdx; j++){
                    g[j - startIdx] = nums[j];
                }
                res[group] = g;
            }
        }
        return res;
    }
}
