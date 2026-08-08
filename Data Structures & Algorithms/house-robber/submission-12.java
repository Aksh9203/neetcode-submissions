// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         if(n == 1) return nums[0];
//         if(n==2) return Math.max(nums[0],nums[1]);

//         int[] t = new int[n + 1];
//         Arrays.fill(t,-1);

//         return Math.max(house(nums,0,t),house(nums,1,t));
//     }

//     public int house(int[] nums, int idx, int[] t){
//         int n = nums.length;
//         if(idx >= n) return 0; 

//         if(t[idx] != -1) return t[idx];

//         return t[idx] = nums[idx] + Math.max(house(nums,idx+2,t), house(nums,idx + 3,t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int[] t = new int[n + 1];

        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[2] + nums[0];

        for(int i=3; i<n; i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }

        return Math.max(t[n-1],t[n-2]);
    }
}