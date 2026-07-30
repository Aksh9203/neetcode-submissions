class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;

        int minJumps = 0;
        int max_pos = 0;
        int l = 0, r = 0;

        while(r < n -1){
            for(int i = l; i<=r; i++){
                max_pos = Math.max(max_pos, i + nums[i]);
            }
            l = r+1;
            r = max_pos;
            minJumps++;
        }
        return minJumps;
    }
}
