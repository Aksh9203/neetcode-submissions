class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int l = 0, r = 0;

        int maxProfit = -1;
        int currentProfit = 0;

        while(r < n){
            while(prices[l] > prices[r]){
                l++;
            }
            if(prices[l] <= prices[r]){
                currentProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit,currentProfit);
                r++;
            }
        }

        return maxProfit;
    }
}
