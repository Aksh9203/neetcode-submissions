class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0; 

        for(int i=0; i<n; i++){
            total += nums[i];
        }

        if(Math.abs(target) > total || (total + target) % 2 != 0 || (total + target) < 0) return 0;

        int sum = (total + target)/2;

        int[][] t = new int[n + 1][sum + 1];

        t[0][0] = 1;

        for(int i=1; i<n + 1; i++){
            for(int j=0; j<sum + 1; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j - nums[i - 1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
