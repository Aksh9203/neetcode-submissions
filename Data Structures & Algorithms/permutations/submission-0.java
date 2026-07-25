class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        per(nums, ans, current, freq);
        return ans;
    }

    public void per(int[] nums, List<List<Integer>> ans, List<Integer> current, boolean[] freq){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                current.add(nums[i]);
                per(nums, ans, current, freq);
                current.remove(current.size() - 1);
                freq[i] = false;
            }
        }
    }
}
