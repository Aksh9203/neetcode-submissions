class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int[] t = new int[n + 1];
        Arrays.fill(t,-1);

        return Math.max(house(nums,0,t),house(nums,1,t));
    }

    public int house(int[] nums, int idx, int[] t){
        int n = nums.length;
        if(idx >= n) return 0; 

        if(t[idx] != -1) return t[idx];

        return t[idx] = nums[idx] + Math.max(house(nums,idx+2,t), house(nums,idx + 3,t));
    }
}
