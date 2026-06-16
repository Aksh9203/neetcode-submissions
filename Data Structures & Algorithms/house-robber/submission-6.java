// class Solution {
//     public int rob(int[] nums) {
//         int[] t = new int[nums.length+1];
//         Arrays.fill(t,-1);
//         return Math.max(robber(nums,0,t),robber(nums,1,t));
//     }

//     public int robber(int[] nums,int i,int[] t){

//         if(i>=nums.length) return 0;

//         if(t[i] != -1) return t[i];
//         int tc = nums[i] + Math.max(robber(nums,i+2,t),robber(nums,i+3,t)); 
//         return t[i] = tc;
//     }
// }

class Solution{
    public int rob(int[] nums){
        int[] t = new int[nums.length+1];

        if(nums.length == 1){
            return nums[nums.length-1];
        }
        else if(nums.length == 2){
            return Math.max(nums[nums.length-1],nums[nums.length-2]);
        }
        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[2] + nums[0];
        // t[nums.length] = 0;

        for(int i=3; i<nums.length;i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }
    return Math.max(t[nums.length-2],t[nums.length-1]);
    }
}