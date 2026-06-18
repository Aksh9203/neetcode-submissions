// class Solution {
//     public boolean canPartition(int[] nums) {
        
//         int sum = 0;
//         for(int i=0; i<nums.length; i++){
//             sum += nums[i];
//         }

//         if(sum%2 != 0) return false;

//         boolean[][] t = new boolean[nums.length+1][(sum/2)+1];

//         return subsetSum(nums,sum/2,nums.length,t);
//     }

//     public boolean subsetSum(int[] arr, int sum, int n,boolean[][] t){

//         if(n == 0 && sum == 0) return true;
//         if(n == 0 && sum > 0) return false;

//         if(t[n][sum] != false) return t[n][sum];

//         if(arr[n-1] <= sum){
//             return t[n][sum] = subsetSum(arr,sum - arr[n-1],n-1,t) || subsetSum(arr,sum,n-1,t);
//         }
//         return t[n][sum] = subsetSum(arr,sum,n-1,t);
//     }
// }

class Solution{
    public boolean canPartition(int[] nums){
        int sum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum%2 != 0 ) return false;

        int eSum = sum/2;

        boolean[][] t = new boolean[n+1][eSum+1];
        
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=eSum; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
    return t[n][eSum];
    }
}
