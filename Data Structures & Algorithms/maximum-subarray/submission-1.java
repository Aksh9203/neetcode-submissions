class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n <= 1) return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
