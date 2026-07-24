class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        sum(candidates, ans, current, target, 0, 0);
        return ans;
    }

    public void sum(int[] nums, List<List<Integer>> ans, List<Integer> current, int target, int total, int idx){
        int n = nums.length;

        if(total == target) ans.add(new ArrayList<>(current));

        for(int i=idx; i<n; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            if(total + nums[i] > target) break;
            current.add(nums[i]);
            sum(nums, ans, current, target, total + nums[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}
