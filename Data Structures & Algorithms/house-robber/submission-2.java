class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length+1];
        Arrays.fill(t,-1);
        return Math.max(robber(nums,0,t),robber(nums,1,t));
    }

    public int robber(int[] nums,int i,int[] t){

        if(i>=nums.length) return 0;

        if(t[i] != -1) return t[i];
        int tc = nums[i] + Math.max(robber(nums,i+2,t),robber(nums,i+3,t)); 
        return t[i] = tc;
    }
}
