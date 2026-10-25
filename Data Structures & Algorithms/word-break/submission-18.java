class Solution {
    Boolean[] t;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        HashSet<String> st = new HashSet<>(wordDict);

        t = new Boolean[n+1];

        return check(s,st,0);
    }

    private boolean check(String s, HashSet<String> st, int idx){
        if(idx == s.length()) return true;

        if(t[idx] != null) return t[idx];

        for(int k = idx + 1; k<=s.length(); k++){
            String newWord = s.substring(idx,k);

            if(st.contains(newWord) && check(s,st,k)) return t[idx] = true;
        }

        return t[idx] = false;
    }
}
