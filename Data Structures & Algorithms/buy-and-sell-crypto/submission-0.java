class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;

        int maxProfit = 0;
        int left = 0, right = 1;

        while(right < prices.length){
            if(prices[right] < prices[left]){
                left++;
                right = left + 1;
                continue; 
            }

            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
        }

        return maxProfit;
    }
}
