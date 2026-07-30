class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int curr_idx = 0;

        for(int i=0; i<n; i++){
            if(i > curr_idx) return false;
            curr_idx = Math.max(curr_idx, i + nums[i]);
            if(curr_idx >= n - 1) return true;
        }

        return true;
    }
}
