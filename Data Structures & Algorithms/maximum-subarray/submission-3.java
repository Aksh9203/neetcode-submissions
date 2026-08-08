class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n ;i++){
            sum += nums[i];
            if(sum < nums[i]){
                sum = nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
