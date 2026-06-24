// class Solution {
//     HashMap<String,Boolean> mp;
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         mp = new HashMap<>();

//         Set<String> words = new HashSet<>(wordDict);
//         return word(s,words);
//     }

//     public boolean word(String s, Set<String> st){
//         int n = s.length();

//         if(st.contains(s)) return true;
//         if(mp.containsKey(s)) return mp.get(s);

//         for(int k=1; k<n; k++){
//             boolean firstStr = word(s.substring(0,k),st); 

//             if(!firstStr) continue;
//             boolean secStr = word(s.substring(k,n),st);

//             if((firstStr) && (secStr)) return true;
//         }

//         mp.put(s,false);
//         return false;
//     }
// }

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] t = new Boolean[n+1];

        Set<String> words = new HashSet<>(wordDict);
        return word(s,0,words,t);
    }

     public boolean word(String s, int i, Set<String> st, Boolean[] t){
        if(i == s.length()) return true;

        if(t[i] != null) return t[i];

        for(int k=i+1; k<s.length()+1; k++){
            String firstStr = s.substring(i,k);

            if(st.contains(firstStr) && word(s,k,st,t)) return t[i] = true;
        }
        return t[i] = false;
    }
}
