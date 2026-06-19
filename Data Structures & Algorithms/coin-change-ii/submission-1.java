class Solution {
    public int change(int amount, int[] coins) {
        int[][] t = new int[coins.length+1][amount+1];
        return sum(coins,amount,coins.length,t);
    }

    public int sum(int[] coins, int amount, int n, int[][] t){
        if(n==0 && amount==0) return 1;
        if(n==0 && amount>0) return 0;

        if(t[n][amount] != 0) return t[n][amount];

        if(coins[n-1]<=amount){
            return t[n][amount] = sum(coins,amount - coins[n-1],n,t) + sum(coins,amount,n-1,t);
        }
        return t[n][amount] = sum(coins,amount,n-1,t);
    }
}
