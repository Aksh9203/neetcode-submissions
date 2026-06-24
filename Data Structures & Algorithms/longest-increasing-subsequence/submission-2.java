class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int prev = Integer.MIN_VALUE;
        int[][] t = new int[n+1][n+1];
        for(int[] t1 : t){
            Arrays.fill(t1,Integer.MIN_VALUE);
        }
        return lcs(nums,0,-1,t);
    }

    public int lcs(int[] nums, int i, int p,int[][] t){
        if(i>=nums.length) return 0;

        if(t[i][p+1] != Integer.MIN_VALUE) return t[i][p+1];

        if(p == -1 || nums[i] > nums[p]){
            return t[i][p+1] = Math.max(1 + lcs(nums,i+1,i,t),lcs(nums,i+1,p,t));
            
        }
        return t[i][p+1] = lcs(nums,i+1,p,t);
    }
}
