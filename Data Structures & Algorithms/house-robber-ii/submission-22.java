class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Place this at the very beginning of your method
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));


        int[] t = new int[n + 1];
        t[0] = nums[0];
        t[1] = nums[1];
        t[2] = nums[0] + nums[2];

        for(int i=3; i<n-1; i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }

        int choice1 = Math.max(t[n-2],t[n-3]);

        t[1] = nums[1];
        t[2] = nums[2];
        t[3] = nums[1] + nums[3];

        for(int i=4; i<n; i++){
            t[i] = nums[i] + Math.max(t[i-2],t[i-3]);
        }

        int choice2 = Math.max(t[n-1],t[n-2]);

        return Math.max(choice1,choice2);
    }
}
