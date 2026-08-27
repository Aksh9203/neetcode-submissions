class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums,0,0);
    }

    private int dfs(int[] nums, int idx, int total){
        if(idx == nums.length) return total;

        // For [3,1,1] we can check [3,1(1)] & [3,1(2)]. Earlier with for loop I might not able to check for[3,1(2)].
        return dfs(nums, idx + 1, nums[idx] ^ total) + dfs(nums, idx + 1, total);
    }
}