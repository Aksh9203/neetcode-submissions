// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         if(n==1) return nums[0];
//         if(n==2) return Math.max(nums[1],nums[0]);

//         int[] t = new int[n + 1];

//         Arrays.fill(t,-1);
//         return Math.max(rob(nums,0,n,t),rob(nums,1,n,t));
//     }

//     private int rob(int[] nums, int idx, int n, int[] t){
//         if(idx >= n) return 0;

//         if(t[idx] != -1) return t[idx];

//         return  t[idx] = nums[idx] + Math.max(rob(nums,idx + 2,n,t), rob(nums,idx + 3,n,t));
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[1],nums[0]);

        int[] t = new int[n + 1];

        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[0] + nums[2];

        for(int i = 3; i<n; i++){
            t[i] = nums[i] + Math.max(t[i - 2],t[i - 3]);
        }

        return Math.max(t[n - 1],t[n - 2]);

    }
}
