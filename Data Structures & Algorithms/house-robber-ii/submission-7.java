class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length + 1];
        Arrays.fill(t,-1);

        int[] t1 = new int[nums.length];
        Arrays.fill(t1,-1);

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums.length == 3) return Math.max(nums[2],Math.max(nums[0],nums[1]));
        return Math.max(Math.max(robber(nums,2,nums.length,t),robber(nums,1,nums.length,t)),robber(nums,0,nums.length-1,t1));
    }

    public int robber(int nums[], int i, int n, int[] t){
        if(i>=n) return 0;

        if(t[i] != -1) return t[i];

        int tc = nums[i] + Math.max(robber(nums,i+2,n,t),robber(nums,i+3,n,t));
        return t[i] = tc;
    }
}
