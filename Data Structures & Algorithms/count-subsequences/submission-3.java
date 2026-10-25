class Solution {
    int[][] t1;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n) return 0;

        t1 = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            t1[i][0] = 1;
        }

        for(int j=1; j<m+1; j++){
            t1[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    t1[i][j] = t1[i-1][j-1] + t1[i-1][j];
                } else {
                    t1[i][j] = t1[i-1][j];
                }
            }
        }
        return t1[n][m];
        
    }
}
