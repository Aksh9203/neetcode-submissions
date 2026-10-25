class Solution {
    int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for(int num : nums){
            total += num;
        }

        if(Math.abs(target) > total || (total + target) % 2 != 0 || (target + total) < 0) return 0;

        int newTarget = (total + target)/2;

        t = new int[n+1][newTarget + 1];

        t[0][0] = 1;

        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<newTarget+1; j++){
                if(nums[i - 1] <= j){
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][newTarget];
    }
}
