class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        sum(nums,ans,current,0,target);
        return ans;
    }

    public void sum(int[] nums, List<List<Integer>> ans, List<Integer> current, int idx, int target){
        if(target <= 0){
            if(target == 0){
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i=idx; i<nums.length; i++){
            current.add(nums[i]);
            sum(nums,ans,current,i, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
