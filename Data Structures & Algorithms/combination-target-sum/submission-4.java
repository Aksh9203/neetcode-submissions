class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        sumOfNumbers(nums,target,ans,current, 0);
        return ans;
    }

    public void sumOfNumbers(int[] nums, int target, List<List<Integer>> ans, List<Integer> current, int idx){
        if(target <= 0){
            if(target == 0) ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(nums[i] > target) continue;
            current.add(nums[i]);
            sumOfNumbers(nums, target - nums[i], ans, current, i);
            current.remove(current.size() - 1);
        }
    }
}
