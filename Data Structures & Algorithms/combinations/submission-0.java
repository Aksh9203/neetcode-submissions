class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        com(n,k,ans,current,1);
        return ans;
    }

    public void com(int n, int k, List<List<Integer>> ans, List<Integer> current, int idx){
        if(current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i<=n; i++){
            current.add(i);
            com(n,k,ans,current,i+1);
            current.remove(current.size() - 1);
        }
    }
}