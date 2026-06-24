class Solution {
    HashMap<String,Boolean> mp;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        mp = new HashMap<>();

        Set<String> words = new HashSet<>(wordDict);
        boolean[][] t = new boolean[n+1][n+1];

        return word(s,words,t);
    }

    public boolean word(String s, Set<String> st, boolean[][] t){
        int n = s.length();

        if(st.contains(s)) return true;
        if(mp.containsKey(s)) return mp.get(s);

        for(int k=1; k<n; k++){
            boolean firstStr = word(s.substring(0,k),st,t); 

            if(!firstStr) continue;
            boolean secStr = word(s.substring(k,n),st,t);

            if((firstStr) && (secStr)) return true;
        }

        mp.put(s,false);
        return false;
    }
}
