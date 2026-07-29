class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();
        check(s,ans,current,0);
        return ans;
    }

    public void check(String s, List<List<String>> ans, List<String> current, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPali(s.substring(idx,i+1))){
                current.add(s.substring(idx,i+1));
                check(s,ans,current,i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPali(String s){
        int n = s.length();

        int i = 0;
        int j = n - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
