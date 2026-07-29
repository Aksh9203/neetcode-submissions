class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums,ans,current,visited);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue;
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                permute(nums,ans,current,visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}