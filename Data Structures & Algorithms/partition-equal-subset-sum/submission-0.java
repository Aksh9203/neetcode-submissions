class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum%2 != 0) return false;

        return subsetSum(nums,sum/2,nums.length);
    }

    public boolean subsetSum(int[] arr, int sum, int n){

        if(n == 0 && sum == 0) return true;
        if(n == 0 && sum > 0) return false;

        if(arr[n-1] <= sum){
            return subsetSum(arr,sum - arr[n-1],n-1) || subsetSum(arr,sum,n-1);
        }
        return subsetSum(arr,sum,n-1);
    }
}
