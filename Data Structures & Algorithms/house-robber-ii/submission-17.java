class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n+1];
        int[] t1 = new int[n];

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        t[1] = nums[1];
        t[2] = nums[2];

        for(int i=3; i<n; i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }

        int max1 = (Math.max(t[n-1],t[n-2]));

        t1[0] = nums[0];
        t1[2] = nums[2] + nums[0];

        for(int i=3; i<n-1; i++){
            t1[i] = nums[i] + Math.max(t1[i-2],t1[i-3]);
        }

        int max2 = (Math.max(t1[n-2],t1[n-3]));

        return Math.max(max1,max2);
    }
}


