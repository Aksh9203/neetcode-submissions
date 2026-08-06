class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        checkPermute(nums,ans,current,visited);
        return ans;
    }

    public void checkPermute(int[] nums, List<List<Integer>> ans, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                current.add(nums[i]);
                checkPermute(nums,ans,current,visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
