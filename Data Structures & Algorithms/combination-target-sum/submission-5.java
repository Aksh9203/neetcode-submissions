class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        check(nums,ans,ls,target,0);
        return ans;
    }

    private void check(int[] nums,List<List<Integer>> ans, List<Integer> ls, int target, int idx){
        if(target <= 0){
            if(target == 0){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(target - nums[i] < 0) continue;
            ls.add(nums[i]);
            check(nums,ans,ls,target - nums[i],i);
            ls.remove(ls.size() - 1);
        }
    }
}
