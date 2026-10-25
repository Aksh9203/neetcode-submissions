class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int sum = 0, maxSum = Integer.MIN_VALUE;


        for(int i=0; i<n; i++){
            sum += nums[i];
            if(nums[i] > sum){
                sum = nums[i];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
