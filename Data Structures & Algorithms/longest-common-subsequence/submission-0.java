class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] t = new int[n+1][m+1]; 

        return lcs(text1,text2,n,m,t);
    }

    public int lcs(String t1, String t2, int n, int m, int[][] t){
        if(n==0 || m==0) return 0;

        if(t[n][m] != 0) return t[n][m];

        if(t1.charAt(n-1) == t2.charAt(m-1)){
            return t[n][m] = 1 + lcs(t1,t2,n-1,m-1,t);
        }
        return t[n][m] = Math.max(lcs(t1,t2,n,m-1,t),lcs(t1,t2,n-1,m,t));
    }
}
