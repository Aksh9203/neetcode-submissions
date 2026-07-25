class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();

        part(s, ans, current, 0);
        return ans;
    }

    public void part(String s, List<List<String>> ans, List<String> current, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = idx; i<s.length(); i++){
            if(isPali(s.substring(idx, i + 1))){
                current.add(s.substring(idx, i + 1));
                part(s, ans, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPali(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
