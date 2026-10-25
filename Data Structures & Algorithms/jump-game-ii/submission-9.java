class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int l = 0, r = 0;
        int cnt = 0, maxJ = 0;

        while(r < n - 1){
            for(int i=l; i<=r; i++){
                maxJ = Math.max(maxJ,i + nums[i]);
            }
            l = r + 1;
            r = maxJ;
            cnt++;
        }

        return cnt;
    }
}
