class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> currSum = new ArrayList<>();
        sum(nums, total, currSum, target, 0, 0);
        return total;
    }

    public void sum(int[] nums, List<List<Integer>> total, List<Integer> currSum, int target, int cal, int idx){
        if(cal >= target){
            if(cal == target){
                total.add(new ArrayList<>(currSum));
            }
            else{
                return;
            }
        }

        if(idx < nums.length && cal < target){
            currSum.add(nums[idx]);
            sum(nums, total, currSum, target, cal + nums[idx], idx);
            currSum.remove(currSum.size() - 1);
            sum(nums, total, currSum, target, cal, idx + 1);
        }
    }
}
