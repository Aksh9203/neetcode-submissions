class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[][] t = new int[n+1][n+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        } 

        return num(s,0,t);
    }

    public int num(String s, int i, int[][] t){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(s.length() == 1){
            if(s.charAt(i) != '0') return 1;
        }

        if(t[i][i] != -1) return t[i][i];

        int res = 0;

        res += num(s,i+1,t);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))){
            res += num(s,i+2,t);
        }

        return t[i][i] = res;
    }
}
