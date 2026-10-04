class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0, right = heights.length - 1;

        while(left < right){
            int vol = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, vol);

            if(heights[left] <= heights[right]){
                left ++;
            }else{
                right--;
            }
        }

        return max;
    }
}
