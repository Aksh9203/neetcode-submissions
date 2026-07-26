class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int k = amount;

        int[][] t = new int[n+1][k+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return coin(coins,n,k,t);
    }

    public int coin(int[] nums, int n, int k, int[][] t){
        if(n == 0 && k == 0) return 1;
        if(n == 0 && k > 0) return 0;

        if(t[n][k] != -1) return t[n][k];

        if(nums[n-1] <= k){
            return t[n][k] = coin(nums, n, k - nums[n - 1], t) + coin(nums,n - 1,k,t);
        }

        return t[n][k] = coin(nums,n-1,k,t);
    }
}
