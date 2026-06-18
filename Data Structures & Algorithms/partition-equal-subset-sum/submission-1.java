class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum%2 != 0) return false;

        boolean[][] t = new boolean[nums.length+1][(sum/2)+1];

        return subsetSum(nums,sum/2,nums.length,t);
    }

    public boolean subsetSum(int[] arr, int sum, int n,boolean[][] t){

        if(n == 0 && sum == 0) return true;
        if(n == 0 && sum > 0) return false;

        if(t[n][sum] != false) return t[n][sum];

        if(arr[n-1] <= sum){
            return t[n][sum] = subsetSum(arr,sum - arr[n-1],n-1,t) || subsetSum(arr,sum,n-1,t);
        }
        return t[n][sum] = subsetSum(arr,sum,n-1,t);
    }
}
