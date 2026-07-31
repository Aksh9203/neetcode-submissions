class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(n == 1){
            if(amount%coins[0] != 0) return -1;
            else return amount / coins[0];
        }

        int[][] t = new int[n+1][amount+1];
        for(int[] t1 : t){
            Arrays.fill(t1, -1);
        }  

        int result = pickMinCoins(coins, n ,amount, t);

        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }

    public int pickMinCoins(int[] coins, int idx, int target, int[][] t){
        if(idx == 0 && target == 0) return 0;
        if(idx == 0 && target > 0) return Integer.MAX_VALUE - 1;

        if(t[idx][target] != -1) return t[idx][target];

        if(coins[idx - 1] <= target){
            return t[idx][target] = Math.min(1 + pickMinCoins(coins,idx, target - coins[idx - 1],t), pickMinCoins(coins, idx - 1, target,t));
        }

        return t[idx][target] = pickMinCoins(coins, idx - 1, target,t);
    }
}
