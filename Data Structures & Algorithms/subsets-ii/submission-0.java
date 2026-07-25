class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        sub(nums, ans, current, 0);
        return ans;
    }

    public void sub(int[] nums, List<List<Integer>> ans, List<Integer> current, int idx){
        ans.add(new ArrayList<>(current));

        for(int i = idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            sub(nums, ans, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
