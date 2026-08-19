class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] t = new int[n+1];
        Arrays.fill(t,-1);

        return num(s,0,t);
    }

    public int num(String s, int i, int[] t){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(t[i] != -1) return t[i];

        int res = 0;
        res += num(s,i+1,t);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))){
            res += num(s,i+2,t);
        }

        return t[i] = res;
    }
}
