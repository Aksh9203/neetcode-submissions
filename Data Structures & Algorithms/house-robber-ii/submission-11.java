// class Solution {
//     public int rob(int[] nums) {
//         int[] t = new int[nums.length + 1];
//         Arrays.fill(t,-1);

//         int[] t1 = new int[nums.length];
//         Arrays.fill(t1,-1);

//         if(nums.length == 1) return nums[0];
//         if(nums.length == 2) return Math.max(nums[0],nums[1]);
//         if(nums.length == 3) return Math.max(nums[2],Math.max(nums[0],nums[1]));
//         return Math.max(Math.max(robber(nums,2,nums.length,t),robber(nums,1,nums.length,t)),robber(nums,0,nums.length-1,t1));
//     }

//     public int robber(int nums[], int i, int n, int[] t){
//         if(i>=n) return 0;

//         if(t[i] != -1) return t[i];

//         int tc = nums[i] + Math.max(robber(nums,i+2,n,t),robber(nums,i+3,n,t));
//         return t[i] = tc;
//     }
// }

class Solution{
    public int rob(int[] nums){
        int[] t = new int[nums.length+1];
        int[] t1 = new int[nums.length];

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums.length == 3) return Math.max(nums[2],Math.max(nums[0],nums[1]));

        t[1] = nums[1];
        t[2] = nums[2];
        t[3] = nums[3] + nums[1];

        t1[0] = nums[0];
        t1[1] = nums[1];
        t1[2] = nums[2] + nums[0];

        for(int i=4; i<nums.length; i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }

        for(int i=3; i<nums.length-1; i++){
            t1[i] = nums[i] + Math.max(t1[i-2],t1[i-3]);
        }

        int max1 = Math.max(Math.max(t[nums.length],t[nums.length-1]),t[nums.length-2]);
        int max2 = Math.max(Math.max(t1[nums.length-3],t1[nums.length-2]),t1[nums.length-1]);

        return Math.max(max1,max2);
    }
}