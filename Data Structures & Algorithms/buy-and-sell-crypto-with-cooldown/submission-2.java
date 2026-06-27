// class Solution {
//     public int maxProfit(int[] prices) {
//         int buy = 1;
//         int n = prices.length;
//         int[][] t = new int[n+1][2];
//         for(int[] t1 : t){
//             Arrays.fill(t1,-1);
//         }

//         return profit(prices,0,n,buy,t);
//     }

//     public int profit(int[] prices, int i, int n, int buy, int[][] t){
//         if(i>=n) return 0;

//         if(t[i][buy] != -1) return t[i][buy];

//         int profit = -1;

//         if(buy == 1){
//             int buy_it = profit(prices,i+1,n,0,t) - prices[i];
//             int no_buy = profit(prices,i+1,n,1,t);

//             profit = Math.max(profit, Math.max(buy_it,no_buy));
//         }
//         else{
//             int sell = prices[i] + profit(prices,i+2,n,1,t);
//             int no_sell = profit(prices,i+1,n,0,t);

//             profit = Math.max(profit, Math.max(sell,no_sell));
//         }
//         return t[i][buy] = profit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] t = new int[n+1];

        if(n<=1) return 0;

        t[0] = 0;
        t[1] = Math.max(prices[1]-prices[0],0);

        for(int i=2; i<n; i++){
            t[i] = t[i-1];
            for(int j=0; j<i; j++){
                int prev_profit = j>=2 ? t[j-2] : 0;
                t[i] = Math.max(t[i],prices[i] - prices[j] + prev_profit);
            }
        }
        return t[n-1]; 
    }
}
