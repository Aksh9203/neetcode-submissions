// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int tsum = 0;

//         for(int i=0; i<nums.length; i++){
//             tsum += nums[i];
//         }

//         if((target + tsum)%2 != 0) return 0;

//         int sum = (target + tsum)/2;
//         int[][] t = new int[nums.length+1][sum+1];

//         return subSum(nums,sum,nums.length,t);
//     }

//     public int subSum(int[] nums, int sum, int n, int[][] t){
//         if(n==0 && sum==0) return 1;
//         if(n==0 && sum>0) return 0;

//         if(t[n][sum] != 0) return t[n][sum];

//         if(nums[n-1] <= sum){
//             return t[n][sum] = subSum(nums,sum - nums[n-1], n-1,t) + subSum(nums,sum,n-1,t);
//         }

//         return t[n][sum] = subSum(nums,sum,n-1,t);
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tSum = 0;
        
        for(int i=0; i<nums.length; i++){
            tSum += nums[i];
        }
        
        if((target + tSum)%2 != 0) return 0;
        
        int sum = (target + tSum)/2;
        int[][] t = new int[nums.length+1][sum+1];
        
        t[0][0] = 1;
        
        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<=sum; j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j - nums[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[nums.length][sum];
    }
}
