class Solution {
    boolean[][] t;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int total = 0;
        for(int num : nums){
            total += num;
        }

        t = new boolean[n + 1][total/2 + 1];

        if(total % 2 != 0) return false;

        return part(nums,total/2,n);
    }

    private boolean part(int[] nums, int target, int n){
        if(n == 0 && target == 0) return true;
        if(n == 0 && target != 0) return false;

        if(t[n][target] != false) return true;

        if(nums[n-1] <= target){
            return t[n][target] = part(nums,target - nums[n - 1], n - 1) || part(nums,target,n - 1);
        }

        return t[n][target] = part(nums,target,n-1);
    }
}
