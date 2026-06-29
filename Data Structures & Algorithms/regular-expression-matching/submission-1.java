class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] t = new Boolean[n+1][m+1];
        return match(s,p,0,0,t);
    }

    public boolean match(String s, String p, int idx, int idx1, Boolean[][] t){
        if(idx1 == p.length()){
            if(idx == s.length()) return true;
            return false;
        }

        if(t[idx][idx1] != null) return t[idx][idx1];

        boolean var = false;

        if(idx < s.length() && (s.charAt(idx) == p.charAt(idx1) || p.charAt(idx1) == '.')){
            var = true;
        }

        if(idx1 + 1 < p.length() && p.charAt(idx1 + 1) == '*'){
            boolean not_take = match(s,p,idx,idx1+2,t);

            boolean take = var && match(s,p,idx+1,idx1,t);
            
            return t[idx][idx1] = take || not_take;
        }
        else{
            return t[idx][idx1] = (var && match(s,p,idx+1,idx1+1,t));
        }
    }
}
