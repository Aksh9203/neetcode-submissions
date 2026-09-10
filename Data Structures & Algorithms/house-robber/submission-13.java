class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n + 1];

        Arrays.fill(t,-1);
        return Math.max(rob(nums,0,n,t),rob(nums,1,n,t));
    }

    private int rob(int[] nums, int idx, int n, int[] t){
        if(idx >= n) return 0;

        if(t[idx] != -1) return t[idx];

        return  t[idx] = nums[idx] + Math.max(rob(nums,idx + 2,n,t), rob(nums,idx + 3,n,t));
    }
}
