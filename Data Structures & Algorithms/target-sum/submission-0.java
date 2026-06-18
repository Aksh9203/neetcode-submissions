class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tsum = 0;

        for(int i=0; i<nums.length; i++){
            tsum += nums[i];
        }

        if((target + tsum)%2 != 0) return 0;

        int sum = (target + tsum)/2;
        int[][] t = new int[nums.length+1][sum+1];

        return subSum(nums,sum,nums.length,t);
    }

    public int subSum(int[] nums, int sum, int n, int[][] t){
        if(n==0 && sum==0) return 1;
        if(n==0 && sum>0) return 0;

        if(t[n][sum] != 0) return t[n][sum];

        if(nums[n-1] <= sum){
            return t[n][sum] = subSum(nums,sum - nums[n-1], n-1,t) + subSum(nums,sum,n-1,t);
        }

        return t[n][sum] = subSum(nums,sum,n-1,t);
    }
}
