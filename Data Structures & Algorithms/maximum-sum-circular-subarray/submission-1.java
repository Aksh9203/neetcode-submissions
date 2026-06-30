class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = 0;

        for(int i=0; i<n; i++){
            total += nums[i];
        }

        int sum1 = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(sum1 + nums[i] <= nums[i]){
                sum1 = nums[i];
            }
            else{
                sum1 += nums[i];
            }
            max = Math.max(max,sum1);
        }

        int sum2 = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(sum2 + nums[i] <= nums[i]){
                sum2 += nums[i];
            }
            else{
                sum2 = nums[i];
            }
            min = Math.min(min,sum2);
        }

        int cirSum = total - min;

        return max > 0 ? Math.max(cirSum,max) : max;
    }
}
















