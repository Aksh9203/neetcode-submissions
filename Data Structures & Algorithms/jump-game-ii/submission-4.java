class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        int l = 0 , r = 0;

        if(n == 1) return 0;

        while(r<n-1){
            int max = 0;
            for(int i=l; i<=r; i++){
                max = Math.max(max,i + nums[i]);   
            }
            l = r + 1;
            r = max;
            cnt++;
        }
        return cnt;
    }
}
