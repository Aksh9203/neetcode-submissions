class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        sum(candidates,ans,current,0,target);
        return ans;
    }

    public void sum(int[] candidates, List<List<Integer>> ans, List<Integer> current, int idx, int target){
        if(target <= 0){
            if(target == 0){
                ans.add(new ArrayList<>(current));
            }
            return;
        }


        for(int i=idx; i<candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            sum(candidates,ans,current,i + 1,target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}
