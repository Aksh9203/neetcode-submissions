class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[1],nums[0]);

        int[] t = new int[nums.length + 1];
        Arrays.fill(t,-1);

        return Math.max(pickHouse(nums,0,t), pickHouse(nums,1,t));
    }

    public int pickHouse(int[] nums, int idx, int[] t){
        if(idx >= nums.length) return 0;

        if(t[idx] != -1) return t[idx];

        int totalCost  = nums[idx] + Math.max(pickHouse(nums,idx + 2, t), pickHouse(nums,idx + 3, t));

        return t[idx] = totalCost;
    }
}
