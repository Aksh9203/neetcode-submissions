class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        check(nums,ans,ls,0);
        return ans;

    }

    private void check(int[] nums, List<List<Integer>> ans, List<Integer> ls, int idx){
        ans.add(new ArrayList<>(ls));

        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            check(nums,ans,ls,i+1);
            ls.remove(ls.size() - 1);
        }    
    }
}
