class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        sumOfNumbers(candidates,target,ans,current,0);
        return ans;
    }

    public void sumOfNumbers(int[] nums, int target, List<List<Integer>> ans, List<Integer> current, int idx){
        if(target <= 0){
            if(target == 0) ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i-1] == nums[i]) continue;
            if(nums[i] > target) continue;
            current.add(nums[i]);
            sumOfNumbers(nums, target - nums[i], ans, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
