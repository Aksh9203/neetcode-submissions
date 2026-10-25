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
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        int res = coin(coins,amount,n);
        
        return  res >= Integer.MAX_VALUE - 1? -1 : res;
    }

    private int coin(int[] nums, int target, int n){
        if(n == 0 && target == 0) return 0;
        if(n == 0 && target > 0) return Integer.MAX_VALUE - 1;

        if(t[n][target] != -1) return t[n][target]; 

        if(nums[n - 1] <= target){
            return t[n][target] = Math.min(1 + coin(nums,target - nums[n-1],n), coin(nums,target,n-1));
        }

        return t[n][target] = coin(nums,target,n-1);
    }
}
