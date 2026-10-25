class Solution {
    int[][] t;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(amount == 0) return 0;

        if(n == 1){
            if(amount % coins[0] != 0){
                return -1;
            } else{
                return amount/coins[0];
            }
        }

        t = new int[n+1][amount + 1];

        for(int j = 0; j<amount + 1; j++){
            t[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount + 1; j++){
                if(coins[i - 1] <= j){
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]],t[i-1][j]); 
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][amount] >= Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
    }
}
