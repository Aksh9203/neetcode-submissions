class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] t = new int[n+1];
        int[] t1 = new int[n+1];

        Arrays.fill(t,-1);
        Arrays.fill(t1,-1);

        return Math.max(pickHouse(nums,0,n-1,t), Math.max(pickHouse(nums,1,n,t1), pickHouse(nums,2,n,t1)));
    }

    public int pickHouse(int[] nums, int idx, int len, int[] t){
        if(idx >= len) return 0;

        if(t[idx] != -1) return t[idx];

        int total = nums[idx] + Math.max(pickHouse(nums, idx + 2, len, t), pickHouse(nums, idx + 3, len,t));

        return t[idx] = total;
    }
}
