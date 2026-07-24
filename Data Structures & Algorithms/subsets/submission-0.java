class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subset(nums, result, current, 0);
        return result;
    }

    public void subset(int[] nums, List<List<Integer>> result, List<Integer> current, int index){
        result.add(new ArrayList<>(current));

        for(int i = index; i<nums.length; i++){
            current.add(nums[i]);
            subset(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
