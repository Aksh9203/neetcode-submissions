class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        HashSet<String> st = new HashSet<>(wordDict);
        Boolean[] t = new Boolean[n+1];

        if(st.contains(s)) return true;

        return wordCheck(s, st , 0,t);
    }

    public boolean wordCheck(String s, HashSet<String> st, int idx, Boolean[] t){
        int n = s.length();
        if(idx == n) return true;

        if(t[idx] != null) return t[idx];

        // if(st.contains(s)) return true;

        for(int k=idx + 1; k<=n; k++){
            String word = s.substring(idx,k);

            if(st.contains(word) && wordCheck(s,st,k,t)) return t[idx] = true;
            
        }
        return t[idx] = false;
    }
}
