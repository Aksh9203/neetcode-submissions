class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        check(nums,ans,ls,freq);
        return ans;
    }

    private void check(int[] nums, List<List<Integer>> ans, List<Integer> ls, boolean[] freq){
        if(ls.size() == nums.length){
            ans.add(new ArrayList<>(ls));
        }
        
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !freq[i - 1]) continue;
            if(!freq[i]){
                freq[i] = true;
                ls.add(nums[i]);
                check(nums,ans,ls,freq);
                ls.remove(ls.size() - 1);
                freq[i] = false;
            }
        }
    }
}