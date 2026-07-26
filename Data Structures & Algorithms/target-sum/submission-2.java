class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int tSum = 0;

        for(int i=0; i<n; i++){
            tSum += nums[i];
        }

        if((tSum + target)%2 != 0) return 0;

        int sum = (tSum + target)/2;
        int[][] t = new int[n+1][sum + 1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        } 

        return find(nums,sum,n, t);
    }

    public int find(int[] nums, int target, int n, int[][] t){
        if(n == 0 && target == 0) return 1;
        if(n == 0 && target > 0) return 0;

        if(t[n][target] != -1) return t[n][target];

        if(nums[n-1] <= target){
            return t[n][target] = find(nums, target - nums[n-1], n -1,t) + find(nums,target,n-1,t);
        }

        return t[n][target] = find(nums,target, n-1,t);
    }
}
