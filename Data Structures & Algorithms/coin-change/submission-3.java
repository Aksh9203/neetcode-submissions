// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if(coins.length==1){
//             if(amount%coins[0] != 0) return -1;
//             else{
//                 return amount/coins[0];
//             }
//         }

//         int[][] t = new int[coins.length+1][amount+1];
//         return change(coins,amount,coins.length,t);
//     }

//     public int change(int[] coins, int amount, int n, int[][] t){
//         if(n==0 && amount==0) return 0;
//         if(n==0 && amount>0) return Integer.MAX_VALUE - 1;

//         if(t[n][amount] != 0) return t[n][amount];

//         if(coins[n-1]<=amount){
//             return t[n][amount] = Math.min(1 + change(coins,amount - coins[n-1],n,t),change(coins,amount,n-1,t));
//         }

//         return t[n][amount] = change(coins,amount,n-1,t);
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==1){
            if(amount%coins[0] != 0) return -1;
            else{
                return amount/coins[0];
            }
        }

        int[][] t = new int[coins.length+1][amount+1];

        for(int j=1; j<=amount; j++){
            t[0][j] = Integer.MAX_VALUE - 1;
        }
        

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1]<=j){
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][amount];
    }
}