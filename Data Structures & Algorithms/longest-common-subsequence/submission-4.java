class Solution {
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        t = new int[n+1][m+1];
        for(int[] t1 : t){
            Arrays.fill(t1,-1);
        }

        return sub(text1,text2,n,m);
    }

    private int sub(String s1, String s2, int n, int m){
        if(n == 0 || m == 0) return 0;
        

        if(t[n][m] != -1) return t[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + sub(s1,s2,n-1,m-1);
        }

        return t[n][m] = Math.max(sub(s1,s2,n-1,m),sub(s1,s2,n,m-1));
    }
}
