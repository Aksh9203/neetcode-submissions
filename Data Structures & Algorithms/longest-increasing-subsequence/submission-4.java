class Solution {
    int[][] t;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        t = new int[n+1][n+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return len(nums,-1,0);

    }

    private int len(int[] nums, int p, int idx){
        int n = nums.length;
        if(idx == n) return 0;

        if(t[n][p+1] != -1) return t[n][p+1];

        if(p == -1 || nums[idx] > nums[p]){
            return t[n][p+1] = Math.max(1 + len(nums,idx,idx+1),len(nums,p,idx+1));
        }

        return t[n][p+1] = len(nums,p,idx+1);
    }
}
