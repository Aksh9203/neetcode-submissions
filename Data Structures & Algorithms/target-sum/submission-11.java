class Solution {
    int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for(int num : nums){
            total += num;
        }

        int newTarget = (total + target)/2;

        if(Math.abs(target) > total || (total + target) % 2 != 0 || (target + total) < 0) return 0;

        t = new int[n+1][newTarget + 1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return find(nums,newTarget,n);
    }

    private int find(int[] nums, int target, int n){
        if(n == 0 && target > 0) return 0;
        if(n == 0 && target == 0) return 1;

        if(t[n][target] != -1) return t[n][target]; 

        if(nums[n - 1] <= target){
            return t[n][target] = find(nums,target - nums[n-1],n-1) + find(nums,target,n-1);
        }

        return t[n][target] = find(nums,target,n-1);
    }
}
