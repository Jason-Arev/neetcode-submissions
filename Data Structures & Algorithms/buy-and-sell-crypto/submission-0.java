class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int profit;
        int maxP = 0;
        
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                profit = prices[r] - prices [l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
