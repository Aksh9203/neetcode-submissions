class Solution {
    public boolean isMatch(String s, String p) {
        return match(s,p,0,0);
    }

    public boolean match(String s, String p, int idx, int idx1){
        if(idx1 == p.length()){
            if(idx == s.length()) return true;
            return false;
        }

        boolean var = false;

        if(idx < s.length() && (s.charAt(idx) == p.charAt(idx1) || p.charAt(idx1) == '.')){
            var = true;
        }

        if(idx1 + 1 < p.length() && p.charAt(idx1 + 1) == '*'){
            boolean not_take = match(s,p,idx,idx1+2);

            boolean take = var && match(s,p,idx+1,idx1);
            
            return take || not_take;
        }
        else{
            return (var && match(s,p,idx+1,idx1+1));
        }
    }
}
