class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        subset(nums,ans,current,0);
        return ans;
    }

    public void subset(int[] nums, List<List<Integer>> ans, List<Integer> current, int idx){
        ans.add(new ArrayList<>(current));

        for(int i=idx; i<nums.length; i++){
            current.add(nums[i]);
            subset(nums,ans,current,i+1);
            current.remove(current.size() - 1);
        }
    }
}
