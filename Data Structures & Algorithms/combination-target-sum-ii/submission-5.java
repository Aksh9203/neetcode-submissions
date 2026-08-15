class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        sum(candidates,ans,ls,target,0);
        return ans;
    }

    public void sum(int[] nums, List<List<Integer>> ans, List<Integer> ls, int target, int idx){
        if(target <= 0){
            if(target == 0) ans.add(new ArrayList<>(ls));
            return;
        }


        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            ls.add(nums[i]);
            sum(nums,ans,ls,target - nums[i], i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}
