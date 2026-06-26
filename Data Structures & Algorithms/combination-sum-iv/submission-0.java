class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] t = new int[target+1];
        Arrays.fill(t,-1);
        return knap(nums,target,t);
    }

    public int knap(int[] nums, int target, int[] t){
        if(target==0) return 1;
        if(target<0) return 0;

        if(t[target] != -1) return t[target];

        int combo = 0;

        for(int i=0; i<nums.length; i++){
            combo += knap(nums,target - nums[i],t);
        }

        return t[target] = combo;
    }  
}