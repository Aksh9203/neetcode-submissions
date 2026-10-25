class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int maxJ = 0;

        for(int i=0; i<n; i++){
            if(i > maxJ) return false;
            maxJ = Math.max(maxJ,i + nums[i]);
            if(maxJ >= n - 1) return true;
        }

        return false;
    }
}
