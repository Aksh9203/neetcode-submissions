class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n+1];
        Arrays.fill(t,-1);

        int[] t1 = new int[n+1];
        Arrays.fill(t1,-1);

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        return Math.max(robb(nums,0,n-1,t), Math.max(robb(nums,1,n,t1), robb(nums,2,n,t1)));
    }

    public int robb(int[] nums, int i, int n, int[] t){
        if(i>=n) return 0;

        if(t[i] != -1) return t[i];
        
        int tc = nums[i] + Math.max(robb(nums,i+2,n, t), robb(nums,i+3, n, t)); 
        return t[i] = tc;
    }
}
