class Solution {
    int[][] t1;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n) return 0;

        t1 = new int[n+1][m+1];

        return dis(s,t,n,m);
    }

    private int dis(String s, String t, int n, int m){
        if(m == 0) return 1;
        if(n == 0) return 0;

        if(t1[n][m] != 0) return t1[n][m];

        if(s.charAt(n-1) == t.charAt(m-1)){
            return t1[n][m] = dis(s,t,n-1,m-1) + dis(s,t,n-1,m);
        }

        return t1[n][m] = dis(s,t,n-1,m);
    }
}
