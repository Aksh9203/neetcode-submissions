class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int l = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            if(i > max) return false;
            max = Math.max(max,i + nums[i]);

            if(max >= n - 1) return true; 
        }
        return true;

        // while(l<n){
        //     if(nums[l] != 0){
        //         l = l + nums[l];
        //     }
        //     else{
        //         if(l == n-1) return true;
        //         else return false;
        //     }
        // }
        // return true;
    }
}
