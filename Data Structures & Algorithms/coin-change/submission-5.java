class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(n == 1){
            if(amount%coins[0] != 0) return -1;
            else{
                return amount/coins[0];
            }
        }

        int[][] t = new int[n+1][amount+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return coin(coins,amount,n,t); 
    }

    public int coin(int[] nums, int tar, int n, int[][] t){
        if(n == 0 && tar == 0) return 0;
        if(n == 0 && tar > 0) return Integer.MAX_VALUE - 1;

        if(t[n][tar] != -1) return t[n][tar];

        if(nums[n-1] <= tar){
            return t[n][tar] = Math.min(1 + coin(nums,tar - nums[n-1], n, t), coin(nums, tar, n - 1, t));
        }

        return t[n][tar] = coin(nums,tar,n-1,t);
    }
}
